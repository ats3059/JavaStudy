package lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GreedStudy1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        GreedStudy1 gs = new GreedStudy1();
//        gs.before(sc,x);
        System.out.println(gs.after(sc,x));



    }

    int before(Scanner sc,int x){
        List<People> list = new ArrayList<>();
        int answer = 0;

        for(int i = 0; i < x; i++){
            list.add(new People(sc.nextInt(),sc.nextInt()));
        }

        for(int i = 0; i < x; i++){
            boolean isBetter = true;
            for(int j = 0; j < x; j++){
                if(i==j) continue;
                if(list.get(i).height < list.get(j).height && list.get(i).weight < list.get(j).weight) {
                    isBetter = false;
                    break;
                }
            }
            if(isBetter) answer++;
        }

        return answer;
    }
    int after(Scanner sc,int x){
        List<People> list = new ArrayList<>();
        int answer = 0;
        int max = 0;

        for(int i = 0; i < x; i++){
            list.add(new People(sc.nextInt(),sc.nextInt()));
        }

        Collections.sort(list);
        max = list.get(0).weight;
        answer++;

        for(int i = 1; i < x; i++){
            if(list.get(i).weight > max){
                max = list.get(i).weight;
                answer++;
            }
        }



        return answer;
    }
}

class People implements Comparable<People>{
    int weight;
    int height;

    People(int h, int w){
        height = h;
        weight = w;
    }

    @Override
    public int compareTo(People o) {
        return o.height - this.height;
    }
}
