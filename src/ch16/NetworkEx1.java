package ch16;

import java.net.InetAddress;
import java.util.Arrays;

public class NetworkEx1 {
    /*
        자바의정석 ch16

	네트워킹

	네트워킹이란 두 대 이상의 컴퓨터를 케이블로 연결하여 네트워크를 구성하는 것을 말한다. 네트워킹의 개념은 컴퓨터들을 서로 연결하여 데이터를 손쉽게
	주고받거나 또는 자원프린터와 같은 주변기기를 함께 공유하고자 하는 노력에서 시작되었다.


	클라이언트/서버는 컴퓨터간의 관계를 역할로 구분하는 개념이다. 서버는 서비스를 제공하는 컴퓨터이고 클라이언트는 서비스를 사용하는 컴퓨터가 된다.
	일반적으로 서버는 다수의 클라이언트에게 서비스를 제공하기 대문에 고사양의 하드웨어를 갖춘 컴퓨터이지만, 하드웨어의 사양에 관계없이
	서비스를 제공하는 소프트웨어가 실행되는 컴퓨터를 서버라 한다.

	네트워크를 구성할 때 전용서버를 두는 것을 서버기반모델이라 하고 별도의 전용서버없이 각 클라이언트가 서버역할을 동시에 수행하는 것을 P2P모델이라 한다.

	모델의 특징

	서버기반 모델
		- 안정적인 서비스의 제공이 가능하다.
		- 공유 데이터의 관리와 보안이 용이하다.
		- 서버 구축 비용과 관리비용이 든다.

	P2P모델

		- 서버구축 및 운용비용을 절감할 수 있다.
		- 자원의 활용을 극대화 할 수 있다.
		- 자원의 관리가 어렵다.
		- 보안이 취약하다.
     */
    public static void main(String[] args) throws Exception{

        InetAddress ip = null;
        InetAddress[] ipArr = null;

        ip = InetAddress.getByName("www.naver.com");
        System.out.println("getHostName() : " + ip.getHostName());
        System.out.println("getHostAddress() : " + ip.getHostAddress());
        System.out.println("toString() : " + ip.toString());

        byte[] ipAddr = ip.getAddress();
        System.out.println("getAddress() : " + Arrays.toString(ipAddr));

        String result = "";
        for(int i = 0; i <ipAddr.length;i++){
            result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
            result += ".";
        }
        System.out.println("getAddress()+256 : " + result);
        System.out.println();


        ip = InetAddress.getLocalHost();
        System.out.println("getHostName : " + ip.getHostName());
        System.out.println("getHostAddress() : " + ip.getHostAddress());
        System.out.println();



        ipArr = InetAddress.getAllByName("www.naver.com");
        for(int i = 0; i < ipArr.length; i++){
            System.out.println("ipArr["+i+"] : " + ipArr[i]);
        }

    }


}
