package book.ch16;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TcpIpMultichatClient {
    public static void main(String args[]) {
       Scanner sc = new Scanner(System.in);
       String name = sc.nextLine();
        try {
            String serverIp = "127.0.0.1";
            // 소켓을 생성하여 연결을 요청한다.
            Socket socket = new Socket(serverIp, 7777);
            System.out.println("서버에 연결되었습니다.");
            Thread sender   = new Thread(new ClientSender(socket, name));
            Thread receiver = new Thread(new ClientReceiver(socket));

            sender.start();
            receiver.start();
        } catch(ConnectException ce) {
            ce.printStackTrace();
        } catch(Exception e) {}
    } // main

    static class ClientSender extends Thread {
        Socket socket;
        DataOutputStream out;
        String name;

        ClientSender(Socket socket, String name) {
            this.socket = socket;
            try {
                out = new DataOutputStream(socket.getOutputStream());
                this.name = name;
            } catch(Exception e) {}
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            try {
                if(out!=null) {
                    out.writeUTF(name);
                }

                while(out!=null) {
                    out.writeUTF("["+name+"]"+scanner.nextLine());					}
            } catch(IOException e) {}
        } // run()
    } // ClientSender

    static class ClientReceiver extends Thread {
        Socket socket;
        DataInputStream in;

        ClientReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
            } catch(IOException e) {}
        }

        public void run() {
            while(in!=null) {
                try {
                    System.out.println(in.readUTF());
                } catch(IOException e) {}
            }
        } // run
    } // ClientReceiver
} // class
