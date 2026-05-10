package main

import (
	"bufio"
	"flag"
	"log/slog"
	"net"
	"sendrec"
	"strings"
)


func main() {

	var dFlag = flag.Bool("d", false, "enable debug log level")
	var pFlag = flag.String("p", "8080", "server port (default: 8080)")
	flag.Parse()

	if *dFlag {
		slog.SetLogLoggerLevel(slog.LevelDebug)
	}

	var cnx net.Conn

	listener, err := net.Listen("tcp", ":" + *pFlag)
	if err != nil {
		slog.Error(err.Error())
		return
	}

	slog.Info("Listening on port: " + *pFlag)

	defer func() {
		slog.Info("Stopped listening on port: " + *pFlag)
		listener.Close()
	}()

	for {

		if cnx != nil {
			cnx.Close()
			slog.Info("Connection closed")
		}

		cnx, err = listener.Accept()
		if err != nil {
		 	slog.Error(err.Error())	
			continue
		}

		slog.Info("New client connected")

		in := bufio.NewReader(cnx)
		out := bufio.NewWriter(cnx)

		err = sendrec.SendMessage(out, "hello\n")
		if err != nil {
			slog.Error(err.Error())
			continue
		}

		start, err := sendrec.ReceiveMessage(in) 
		if err != nil {
			slog.Error(err.Error())
			continue
		}

		slog.Debug("Protocol", slog.String("expected",  "start"), slog.String("received", start))

		if strings.Compare(start, "start") != 0 {
			continue
		}

		err = sendrec.SendMessage(out, "ok\n")
		if err != nil {
			slog.Error(err.Error())
			continue
		}

		for {

			data, err := sendrec.ReceiveMessage(in) 
			if err != nil {
				slog.Error(err.Error())
				break
			}

			slog.Debug("Protocol", slog.String("expected", "data or end"), slog.String("received", data))

			if strings.Compare(data, "end") == 0 {
				break 
			}

			if strings.Compare(data, "data") != 0 {
				break
			}

			err = sendrec.SendMessage(out, "ok\n")
			if err != nil {
				slog.Error(err.Error())
				break
			}
		}
	}
}

