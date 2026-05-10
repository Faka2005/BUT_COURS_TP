package main

import (
	"bufio"
	"flag"
	"log/slog"
	"math/rand/v2"
	"net"
	"sendrec"
	"strings"
)

func main() {

	var dFlag = flag.Bool("d", false, "enable debug log level")
	var aFlag = flag.String("a", "127.0.0.1", "server address (default: 127.0.0.1)" )
	var pFlag = flag.String("p", "8080", "server port (default: 8080)")
	flag.Parse()

	if *dFlag {
		slog.SetLogLoggerLevel(slog.LevelDebug)
	}

	remote := *aFlag + ":" + *pFlag
	cnx, err := net.Dial("tcp", remote)

	if err != nil {
		slog.Error(err.Error())
		return
	}

    defer func() {
		cnx.Close()
		slog.Info("Disconnected")
	}()

	slog.Info("Connected")

	in := bufio.NewReader(cnx)
	out := bufio.NewWriter(cnx)

	hello, err := sendrec.ReceiveMessage(in)
	if err != nil {
		slog.Error(err.Error())
		return
	}
	
	slog.Debug("Protocol", slog.String("expected", "hello"), slog.String("received", hello))

	if strings.Compare(hello, "hello") != 0 {
		slog.Error(err.Error())
		return
	}

	err = sendrec.SendMessage(out, "start\n")
	if err != nil {
		slog.Error(err.Error())
		return
	}
	
	ok, err := sendrec.ReceiveMessage(in)
	if err != nil {
		slog.Error(err.Error())
		return
	}

	slog.Debug("Protocol", slog.String("expected", "ok"), slog.String("received", ok))

	if strings.Compare(ok, "ok") != 0 {
			return
	}
	
	for tour := 1 + rand.UintN(5) ; tour > 0; tour -- {

		err = sendrec.SendMessage(out, "data\n")
		if err != nil {
			slog.Error(err.Error())
			return
		}

		ok, err = sendrec.ReceiveMessage(in)
		if err != nil {
			slog.Error(err.Error())
			return
		}

		slog.Debug("Protocol", slog.String("expected", "ok"), slog.String("received", ok))

		if strings.Compare(ok, "ok") != 0 {
			return
		}

	}

	sendrec.SendMessage(out, "end\n")
	if err != nil {
		slog.Error(err.Error())
		return
	}

	return
}

