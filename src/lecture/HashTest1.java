package lecture;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        HashTest1 ht = new HashTest1();
        System.out.println(ht.solution(n,str));
    }


    private String solution(int n , String str){

        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(str.charAt(i))){
                 map.put(str.charAt(i),map.get(str.charAt(i)) + 1);
            }else{
                map.put(str.charAt(i),0);
            }
        }

        return map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey().toString();
    }

}
