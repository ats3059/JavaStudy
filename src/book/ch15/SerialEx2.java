package book.ch15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class SerialEx2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "UserInfo.ser";
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);

        UserInfo u1 = (UserInfo)ois.readObject();
        UserInfo u2 = (UserInfo)ois.readObject();
        List<UserInfo> list = (List<UserInfo>)ois.readObject();

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(list);

        ois.close();



    }
}
