package book.ch16;

import java.io.*;
import java.net.Socket;

public class TcpIpClient {
    /*
    네트워크 3
	소켓

	소켓 프로그래밍은 소켓을 이용한 통신 프로그래밍을 뜻하는데, 소켓이란 프로세스간의 통신에 사용되는 양쪽 끝단을 의마한다.
	서로 멀리 떨어진 두사람이 통신하기 위해서 전화기가 필요한 것처럼, 프로세스간의 통신을 위해서는 그 무언가가 필요하고
	그것이 바로 소켓이다.
	자바에서는 java.net패키지를 통해 소켓 프로그래밍을 지원하는데, 소켓통신에 사용되는
	프로토콜에 따라 다른 종류의 소켓을 구현하여 제공한다.


	TCP/IP 프로토콜은 이기종 시스템간의 통신을 위한 표준 프로토콜로 프로토콜의 집합이다.
	TCP와 UDP 모두 TCP/IP 프로토콜에 포함되어 있으며, OSI 7계층의 전송계층에 해당하는 프로토콜이다.
	TCP와 UDP는 전송 방식이 다르며, 각 방식에 따른 장단점이 있다. 어플리케이션의 특징에 따라 적절한
	프로토콜을 선택하여 사용하도록 하자.

	TCP/IP연결기반
	 연결 후 통신
	 1:1 통신방식
     - 데이터의 경계를 구분안함 신뢰성 있는 데이터 전송
	 - 데이터의 전송순서가 보장됨
	 - 데이터의 수신여부를 확인함
	 - 패킷을 관리할 필요가 없음
	 UDP보다 전송속도가 느림

	관련클래스 : Socket
			  ServerSocket

	UDP
	 비연결기반
	  - 연결없이 통신(소포)
	  - 1:1 , 1:N , N:N 통신방식
	  데이터의 경계를 구분함.
	  신뢰성 없는 데이터 전송
	   - 데이터의 전송순서가 바뀔 수 있음
	   - 데이터의 수신여부를 확인안함
	    (데이터가 손실되어도 알 수 없음)
	   - 패킷을 관리해주어야함
	   TCP보다 전송속도가 빠름

	   DatagramSocket
	   DatagramPacket
	   MulticastSocket



     */
    public static void main(String[] args) throws IOException {

        String serverIp = "127.0.0.1";

        System.out.println("서버에 연결중입니다. 서버IP : " + serverIp);
        Socket socket =  new Socket(serverIp,7777);

        InputStream in = socket.getInputStream();
        DataInputStream dis = new DataInputStream(in);

        System.out.println("서버로부터 받은 메시지" + dis.readUTF());
        System.out.println("연결을 종료합니다.");
        dis.close();
        socket.close();
        System.out.println("연결이 종료되었습니다.");

    }
}
