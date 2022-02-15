package Programmers;

import com.sun.jdi.CharType;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordReversal {

    public static void main(String[] args) {
        String[] strArr = {"good","Time","Big"};
//        answer1(strArr);
//        answer2(strArr);
        answer3(strArr);

    }

    private static void answer3(String[] strArr) {
        for(String str : strArr){
            char[] c = str.toCharArray();
            int lt = 0 , rt = str.length()-1;
            while(lt < rt){
                char temp = c[lt];
                c[lt] = c[rt];
                c[rt] = temp;
                lt += 1;
                rt -=1;
            }
            String temp = String.valueOf(c);
            System.out.println(temp);
        }
    }

    private static void answer2(String[] strArr) {
        for(int i = 0; i < strArr.length; i++){
            StringBuilder sb = new StringBuilder(strArr[i]);
            sb.reverse();
            strArr[i] = sb.toString();
        }
        System.out.println(Arrays.toString(strArr));
    }

    private static void answer1(String[] strArr) {
        String[] temp = new String[strArr.length];
        for(int i = 0; i < strArr.length; i++){
            String str = strArr[i];
            temp[i] = "";
            for(int j = str.length()-1; j >= 0; j--){
                temp[i] += str.charAt(j);
            }
        }
    }


}

class WordReversal2{
    public static void main(String[] args) {
        String str = "a#b!GE*T@S";

        int lt = 0 , rt = str.length()-1;
        char[] c = str.toCharArray();

        while(lt < rt){
            if(!Character.isAlphabetic(c[lt])){
                ++lt;
            }else if(!Character.isAlphabetic(c[rt])){
                --rt;
            }else{
                char temp = c[lt];
                c[lt] = c[rt];
                c[rt] = temp;
                ++lt;
                --rt;
            }
        }

        System.out.println(String.valueOf(c));

    }



}
