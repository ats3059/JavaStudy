package algo;
import java.util.*;
public class MenuRemake {
    static Map<String,Integer> map = new HashMap<>();

    static List<String> list = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) {
        new MenuRemake().solution(new String[]{"XYZ", "XWY", "WXA","DAC","DAC"} , new int[]{2, 3, 4});
    }

    public List<String> solution(String[] orders, int[] course) {


        for(int i : course){
            char[] temp = new char[i];
            for(String s : orders){
                if(s.length() < i) continue;

                combiDfs(0,0,s,temp,i);
            }

            for (String s : map.keySet()) {
                Integer value = map.get(s);
                if(value >= max && value >= 2) list.add(s);
            }
            map.clear();
            max = 0;
        }

        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        return list;
    }

    void combiDfs(int l, int s ,String str , char[] temp , int loop) {
        if(l == loop) {
            char[] temp2 = Arrays.copyOf(temp, temp.length);
            Arrays.sort(temp2);
            StringBuilder sb = new StringBuilder();
            for(char c : temp2) {
                sb.append(c);
            }
            String menu = sb.toString();

            Integer value = map.getOrDefault(menu,0)+1;
            max = Math.max(max,value);
            map.put(menu,value);
        }else{
            for (int i = s; i < str.length(); i++) {
                temp[l] = str.charAt(i);
                combiDfs(l+1,i+1,str,temp,loop);
            }
        }
    }

}
