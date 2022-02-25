package Programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTest4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String m = sc.next();

        HashTest4 ht = new HashTest4();
        System.out.println(ht.solution(n,m));
    }

//    bacaAacba
//            abc

    int solution(String s1 , String s2){
       int answer = 0;
       Map<Character,Integer> amap = new HashMap<>();
       Map<Character,Integer> bmap = new HashMap<>();
       int len = s1.length();
       int len2 = s2.length()-1;
       int lt = 0;

       for(char c : s2.toCharArray()){
           bmap.put(c,bmap.getOrDefault(c,0)+1);
       }

       for(int i = 0; i < len2;i++){
           amap.put(s1.charAt(i),amap.getOrDefault(s1.charAt(i),0)+1);
       }

       for(int rt = len2; rt < len;rt++){
           amap.put(s1.charAt(rt),amap.getOrDefault(s1.charAt(rt),0)+1);
           if(amap.equals(bmap)) answer++;
           amap.put(s1.charAt(lt),amap.get(s1.charAt(lt))-1);
           if(amap.get(s1.charAt(lt))==0) amap.remove(s1.charAt(lt));
           lt++;

       }






        return answer;
    }

}
