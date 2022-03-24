package ch16;

import java.net.*;

public class NetworkEx3 {
    /*
         네트워킹 정리2

	URLConnection

	URLConnection은 어플리케이션과 URL간의 통신연결을 나타내는 클래스의 최상위 클래스로 추상클래스이다.
	URLConnection을 상속받아 구현한 클래스로는 HttpURLConnection과 JarURLConnection이 있으며
	URL의 프로토콜이 http프로토콜이라면 openConnection()은 Http URLConnection을 반환한다.
	URLConnection을 사용해서 연결하고자하는 자원에 접근하고 읽고 쓰기를 할 수 있다.
	그 외에 관련된 정보를 읽고 쓸 수 있는 메서드가 제공된다.



     */
    public static void  main(String args[]) {
        URL url = null;
        String address = "https://www.naver.com/";

        try {
            url = new URL(address);
            URLConnection conn = url.openConnection();

            System.out.println("conn.toString():"+conn);
            System.out.println("getAllowUserInteraction():"+conn.getAllowUserInteraction());
            System.out.println("getConnectTimeout():"+conn.getConnectTimeout());
            System.out.println("getContent():"+conn.getContent());
            System.out.println("getContentEncoding():"+conn.getContentEncoding());
            System.out.println("getContentLength():"+conn.getContentLength());
            System.out.println("getContentType():"+conn.getContentType());
            System.out.println("getDate():"+conn.getDate());
            System.out.println("getDefaultAllowUserInteraction():"+conn.getDefaultAllowUserInteraction());
            System.out.println("getDefaultUseCaches():"+conn.getDefaultUseCaches());
            System.out.println("getDoInput():"+conn.getDoInput());
            System.out.println("getDoOutput():"+conn.getDoOutput());
            System.out.println("getExpiration():"+conn.getExpiration());
            System.out.println("getHeaderFields():"+conn.getHeaderFields());
            System.out.println("getIfModifiedSince():"+conn.getIfModifiedSince());
            System.out.println("getLastModified():"+conn.getLastModified());
            System.out.println("getReadTimeout():"+conn.getReadTimeout());
            System.out.println("getURL():"+conn.getURL());
            System.out.println("getUseCaches():"+conn.getUseCaches());
        } catch(Exception e) {
            e.printStackTrace();
        }
    } // main
}

