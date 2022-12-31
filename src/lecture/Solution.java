package lecture;

import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int result = 0;
        String[] lines = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

        int[] cntArr = new int[lines.length];
        for(int i = 0; i < lines.length; i++){
            Date preDate = sdf.parse(lines[i].split(" ")[1]);
            long preEnd = preDate.getTime();
            System.out.println("preEnd = " + preEnd);
            for(int j = i; j < lines.length; j++){
                double sec = getSecond(lines[j]);
                Date nextDate = sdf.parse(lines[j].split(" ")[1]);
                long nextStart = (long)(nextDate.getTime() - sec * 1000 + 1);
                if(preEnd + 1000 > nextStart){
                    cntArr[i] += 1;
                }
            }
        }

        Arrays.sort(cntArr);
        System.out.println(cntArr[cntArr.length-1]);


    }

    private static double getSecond(String str) {
        String[] tempArr = str.split(" ");
        String result = tempArr[2];
        double convertSec = Double.parseDouble(result.substring(0, result.length() - 1));
        return convertSec;
    }




}

