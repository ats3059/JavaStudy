package lecture;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTest2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String str2 = sc.next();

        HashTest2 ht = new HashTest2();
        System.out.println(ht.solution(str,str2));
    }

    String solution(String str, String str2){
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        int len = str.length();
        String answer = "YES";

        for(int i = 0; i < len; i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
            map2.put(str2.charAt(i),map2.getOrDefault(str2.charAt(i),0)+1);
        }

        for(char c : map.keySet()){
            if(map2.get(c) != map.get(c)) answer = "NO";
        }




        return answer;
    }

}
