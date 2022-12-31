package book.ch16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer3 {
    public static void main(String[] args) {
        ServerSocket ss = null;
        try{
            ss = new ServerSocket(7777);
        }catch (IOException e){
            System.out.println("서버에서 예외가 뜸");
        }
        System.out.println("서버의 대기가 시작됨");

        try{
            while(true){
                ss.setSoTimeout(5000);
                
                Socket sc = ss.accept();
                System.out.println(getTime() + "클라이언트 연결");
                
                OutputStream os = sc.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                
                dos.writeUTF("메세지 보냄 ㅇㅇ ");

                dos.close();
                sc.close();

            }
        }catch (SocketTimeoutException e){
            System.out.println("서버와의 연결 가능 시간을 초과했습니다.");
            System.exit(0);
        }catch (IOException e){
            e.printStackTrace();
        }





    }
    static String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        return sdf.format(new Date());
    }
}
