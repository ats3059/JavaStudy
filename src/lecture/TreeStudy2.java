package lecture;

public class TreeStudy2 {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        n = 3;
        arr = new int[n+1];
        dfs(1);
    }

    static void dfs(int l){
        if(l == n+1){
            String tmp = "";

            for(int i = 1; i<= n; i++){
                if(arr[i] == 1) tmp += i + " ";
            }

            System.out.println(tmp);
        }else{
            arr[l] = 1;
            dfs(l+1);
            arr[l] = 0;
            dfs(l+1);
        }


    }


}
