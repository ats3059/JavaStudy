package book.ch15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerialEx1 {
    public static void main(String[] args) throws IOException {
        String fileName = "UserInfo.ser";
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        
        UserInfo u1 = new UserInfo();
        UserInfo u2 = new UserInfo("gd","1123",10);

        List<UserInfo> list= new ArrayList<>();
        list.add(u1);
        list.add(u2);
        
        oos.writeObject(u1);
        oos.writeObject(u2);
        oos.writeObject(list);
        oos.close();
        System.out.println("직렬화끝");
        

    }
}
