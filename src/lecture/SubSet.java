package lecture;


import java.util.Scanner;


public class SubSet {
    static int total;
    static String answer = "NO";
    static int[] arr;
    static boolean isFinal;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];
        total = 0;
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        SubSet ss = new SubSet();
        isFinal = false;
        ss.dfs(0,0);

        System.out.println(answer);

    }
    void dfs(int n, int sum){
        if(total - sum == sum || isFinal == true){
            isFinal = true;
            answer = "YES";
            return;
        }else{
            if(n < arr.length){
                dfs(n+1,arr[n]+sum);
                dfs(n+1,sum);
            }
        }
    }


}
