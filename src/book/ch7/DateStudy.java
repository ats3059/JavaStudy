package book.ch7;

import java.util.*;

public class DateStudy {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal.set(2016,9,15,9,0);
        cal1.set(2016,9,15,8,59,57);
        cal2.set(2016,9,15,8,59,58);
        System.out.println(String.format("기준시 %s",cal.getTimeInMillis()));
        System.out.println(String.format("시작시 %s",cal1.getTimeInMillis()));
        System.out.println(String.format("종료시 %s",cal2.getTimeInMillis()));
        



        List<Long> list = new ArrayList<>();
        list.add(cal.getTimeInMillis());
        list.add(cal1.getTimeInMillis());
        list.add(cal2.getTimeInMillis());
        Collections.sort(list);

        System.out.println("list = " + list);
        

    }
}
