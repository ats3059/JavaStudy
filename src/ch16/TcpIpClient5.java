package ch16;


import java.io.IOException;

import java.net.Socket;

public class TcpIpClient5 {
    public static void main(String[] args) throws IOException{

        String serverIp = "127.0.0.1";

        System.out.println("서버에 연결중입니다. 서버IP : " + serverIp);
        Socket socket =  null;
        try{
            socket = new Socket(serverIp,7777);
        }catch (IOException e){
            e.getStackTrace();
        }

        Sender sender = new Sender(socket,"클라이언트");
        Receiver receiver = new Receiver(socket,"서버");

        new Thread(sender).start();
        new Thread(receiver).start();





    }
}
