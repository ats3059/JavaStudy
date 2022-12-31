package book.ch16;

import java.io.*;
import java.net.URL;

public class NetworkEx5 {
    public static void main(String[] args) throws IOException {
        String address = "https://www.naver.com";
        URL url = new URL(address);

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("naver.html"));
        String read = "";

        while((read = br.readLine()) != null){
            bw.write(read);
        }

        br.close();
        bw.close();
    }
}
