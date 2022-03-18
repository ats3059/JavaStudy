package ch15;

import java.io.*;

public class FileSplit2 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\user1\\Desktop\\듀오백.mp4");
        String fileName = file.getName();
        //1MB
        long volume = 1000 * 1000;

        int i = 0;
        int number = 1;

        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        int x = 0;

        while((x = bis.read()) > -1){
            if(i%volume == 0){
                if(i!=0){
                    bos.close();
                }
                fos = new FileOutputStream(String.format("%s%s%d", fileName,"_.",number++));
                bos = new BufferedOutputStream(fos);
            }
            bos.write(x);
            i++;
        }

        bis.close();
        bos.close();




    }
}
