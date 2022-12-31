package book.ch16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpIpServer5 {
    public static void main(String[] args) throws IOException{

        ServerSocket ss = null;

        try{
            System.out.println("서버소켓 준비중..");
            ss = new ServerSocket(7777);
            System.out.println(ss.getLocalSocketAddress());
            System.out.println("서버소켓 준비완료..!");
        }catch (IOException e){
            System.out.println("뭔가 문제가 생긴듯;?");
        }

        System.out.println("접속자 대기중 ...");
        ss.setSoTimeout(10000);
        Socket sc = ss.accept();
        System.out.println("클라이언트 접속완료");

        Sender se = new Sender(sc,"서버");
        Receiver re = new Receiver(sc,"클라이언트");
        new Thread(se).start();
        new Thread(re).start();

    }
}

class Receiver implements  Runnable{

    Socket sc;
    DataInputStream dis;
    String name;
    Receiver(Socket sc,String str){
        this.sc = sc;
        this.name = str;
        try {
            dis = new DataInputStream(sc.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {
        while(dis!=null){
            try {
                System.out.println(name + dis.readUTF());
            } catch (IOException e) {


            }
        }
    }
}

class Sender implements Runnable{
    Socket sc;
    DataOutputStream dos;
    String who;
    Sender(Socket sc, String who){
        this.sc = sc;
        this.who = who;
        try {
            dos = new DataOutputStream(sc.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while(dos!=null){
            try {
                dos.writeUTF(sc.nextLine());
            } catch (IOException e) {

            }
        }


    }
}



