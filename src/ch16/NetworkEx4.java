package ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NetworkEx4 {
    public static void main(String[] args) throws IOException {
        //url이 유효하지 않다면 -> Malformed - URLException이 발생
        //openStream()을 호출하면 -> URL의 InputStream을 얻음
        //openStream()은 -> url.openConnection() 호출 후 URLConnection을 반환받고
        //반환받은 URLConnection에서 InputStream을 반환 받은 것.
        //Http에서 Content를 반환 받는 것..
        String address = "https://www.naver.com";
        URL url = new URL(address);
        String contentType = url.openConnection().getContentType();
        if(contentType.contains("text")) System.out.println("문자 정보니까 Reader사용해라");
        


//        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
//
//        String read = "";
//        while((read = br.readLine()) != null){
//            System.out.println(read);
//        }
//
//        br.close();


    }
}
