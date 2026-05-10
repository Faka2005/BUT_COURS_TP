package sendrec

import (
	"bufio"
	//"log"
)

func SendMessage(out *bufio.Writer, message string) (error) {
		_, err := out.WriteString(message)
		if err != nil {
			return err
		}
		err = out.Flush()
		if err != nil {
			return err
		}
		//log.Println("Envoi du message :", message[0:len(message)-1])
		return nil 
}


func ReceiveMessage(in *bufio.Reader) (message string, err error) {
	message, err = in.ReadString('\n')
	if err != nil {
	    return "", err	
	}
	return message[0:len(message)-1], nil
}

