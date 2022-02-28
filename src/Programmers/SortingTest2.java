package Programmers;

import java.util.Arrays;
import java.util.Scanner;

public class SortingTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Coordinate[] arr = new Coordinate[n];

        for(int i = 0; i < n; i++){
            arr[i] = new Coordinate(sc.nextInt(),sc.nextInt());
        }

        SortingTest2 st = new SortingTest2();
        st.solution(n,arr);


    }

    Coordinate[] solution(int n, Coordinate[] arr){
        Arrays.sort(arr);
        for(Coordinate c : arr){
            System.out.println(c.x + " " + c.y);
        }

        return arr;
    }


}
class Coordinate implements Comparable<Coordinate>{
    int x;
    int y;

    Coordinate(int x , int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Coordinate o) {
        if(this.x == o.x && this.y < o.y) return -1;
        if(this.x < o.x) return -1;
        return 1;
    }

}
