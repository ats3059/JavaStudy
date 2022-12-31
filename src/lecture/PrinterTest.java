package algo;



import java.util.*;

public class PrinterTest {
    public static void main(String[] args) {
        PrinterTest pt = new PrinterTest();
        System.out.println(pt.solution(new int[]{2, 1, 3 ,2} , 3));
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        Queue<Location> q = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++){
            list.add(priorities[i]);
            q.offer(new Location(i,priorities[i]));
        }

        Collections.sort(list,Comparator.reverseOrder());

        while(!q.isEmpty()){

            Location l = q.poll();
            if(idx == priorities.length) idx = 0;
            if(l.value == list.get(idx)){
                answer++;
                idx++;
                if(location == l.idx) return answer;
            }else{
                q.offer(l);
            }
        }


        return answer;
    }
}
class Location {
    int idx;
    int value;

    Location(int idx , int value){
        this.idx = idx;
        this.value = value;
    }

}