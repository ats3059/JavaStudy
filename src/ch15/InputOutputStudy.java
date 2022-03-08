package ch15;

import java.io.*;


public class InputOutputStudy {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = null;
        String filePath = "C:\\Users\\user1\\Desktop\\StateLessUseReason.txt";
        fis = new FileInputStream(new File(filePath));
//        FileReader fr = new FileReader(new File(filePath));
//        FileWriter fw = new FileWriter(new File("C:\\Users\\user1\\Desktop\\copy.txt"),true);
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\user1\\Desktop\\copy.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(fos,5);

        for(int i = '1'; i <= '9'; i++){
            bos.write(i);
        }

        bos.close();

        int i = 0;
//        while((i = fr.read()) > -1){
//            fw.write(i);
//        }


//        fw.append('c');
//
//        fw.close();
//        fr.close();


    }


}
