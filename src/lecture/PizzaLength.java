package lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PizzaLength {
    static int[][] area;
    static List<List<Integer>> pz;
    static List<List<Integer>> hs;
    static List<Integer[]> combiL;
    static Integer[] combi;
    static int n;
    static int m;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        PizzaLength pl = new PizzaLength();

        area = new int[n+1][n+1];

        pz = new ArrayList<>();
        hs = new ArrayList<>();
        pz.add(new ArrayList<>());
        hs.add(new ArrayList<>());
        combiL = new ArrayList<>();

        for(int i = 1; i <= n;i++){
            pz.add(new ArrayList<>());
            hs.add(new ArrayList<>());
            for(int j = 1; j<= n;j++){
                area[i][j] = sc.nextInt();
                if(area[i][j] == 1) hs.get(i).add(j);
                if(area[i][j] == 2) {
                    cnt++;
                    pz.get(i).add(j);
                }
            }
        }
        combi = new Integer[n];
        pl.dfsCombi(0,1);
        pl.diff(0,0);

    }

    void dfsCombi(int l,int s){
        if(l==m){
            combiL.add(Arrays.copyOf(combi,combi.length));
        }else{
            for(int i = s; i <= cnt; i++){
                    combi[l] = i;
                    dfsCombi(l+1,i+1);
            }
        }
    }

    void diff(int l,int sum){
        if(l == m){

        }else{
            for(Integer[] ar : combiL){
                for(int x : ar){

                }
            }
        }

    }

}
