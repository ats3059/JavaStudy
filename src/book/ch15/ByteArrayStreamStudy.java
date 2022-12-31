package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayStreamStudy {
    public static void main(String[] args){
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream bis = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try{
            while(bis.available() > 0){
                int len = bis.read(temp);
                System.out.println(Arrays.toString(temp));
                bos.write(temp,0,len);
                System.out.println(Arrays.toString(bos.toByteArray()));
            }
        }catch (IOException e){

        }finally {

        }

    }

}

