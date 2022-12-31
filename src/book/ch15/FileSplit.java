package ch15;

import java.io.*;

class FileSplit {
    public static void main(String[] args) {

        final int VOLUME = Integer.parseInt("1000") * 1000;
//        1000000;

        try {
            String filename = "C:\\Users\\user1\\Desktop\\듀오백.mp4";

            FileInputStream     fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);

            FileOutputStream     fos = null;
            BufferedOutputStream bos = null;

            int data = 0;
            int i = 0;
            int number = 0;

            while((data = bis.read()) != -1) {
                if (i%VOLUME==0) {
                    if (i!=0) {
                        bos.close();
                    }
                    fos = new FileOutputStream(filename + "_."+ ++number);
                    bos = new BufferedOutputStream(fos);
                }
                bos.write(data);
                i++;
            }

            bis.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }	// end of try-catch
    } // end of main
} // end of class FileSplit

