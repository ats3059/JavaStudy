package book.ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer4 implements Runnable {
    String name = "";
    ServerSocket ss;
    Thread[] threads;
    public static void main(String[] args) {
        TcpIpServer4 tcpIpServer4 = new TcpIpServer4(4);
    }

    TcpIpServer4(){

    }

    TcpIpServer4(int num){
        try{
            System.out.println("서버 생성");
            ss = new ServerSocket(7777);
            threads = new Thread[num];
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("무슨 문제가 생겼나?");
        }
        createThread(num);
    }

    void createThread(int num){
        for(int i = 0; i < num; i++){
            threads[i] = new Thread(this);
            threads[i].start();
        }
    }



    @Override
    public void run() {

        try {

            System.out.println(Thread.currentThread().getName() + "대기중");
            Socket socket = ss.accept();
            System.out.println(Thread.currentThread().getName() + "서버와 연결되었습니다.");
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(Thread.currentThread().getName() + " 가 응답을 보냈습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
