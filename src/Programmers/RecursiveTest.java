package Programmers;

public class RecursiveTest {
    static int[] fiboArr;

    public static void main(String[] args) {
        int n = 45;
//        arrFibo(n);
//        System.out.println(dfsFibo(n));
        fiboArr = new int[n + 1];
        dfsFibo(n);
        for (int i = 1; i <= n; i++) {
            System.out.println(fiboArr[i]);
        }


    }

    static void arrFibo(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (i + 1 <= 2) arr[i] = 1;
            else arr[i] = arr[i - 1] + arr[i - 2];
            System.out.print(arr[i] + " ");
        }
    }

    static int dfsFibo(int n) {
        if (n == 1) return fiboArr[n] = 1;
        else if (n == 2) return fiboArr[n] = 1;
        else {
            if (fiboArr[n] == 0) {
                fiboArr[n-2] = dfsFibo(n-2);
                fiboArr[n-1] = dfsFibo(n-1);
                fiboArr[n] = fiboArr[n-1] + fiboArr[n-2];
            }
            return fiboArr[n];
        }
    }
}





