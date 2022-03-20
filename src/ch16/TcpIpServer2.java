package ch16;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(7777);
        System.out.println("서버의 준비가 완료됨");
        //서버가 클라이언트의 응답을 기다린다.
        Socket sc = ss.accept();
        System.out.println("클라이언트와 연결됨 " + sc.getInetAddress());
        System.out.println("클라이언트의 포트" + sc.getPort());
        System.out.println("서버가 사용중인 포트" + sc.getLocalPort());

        OutputStream os = sc.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        dos.writeUTF("TestMessage");

        dos.close();
        sc.close();



    }
}
