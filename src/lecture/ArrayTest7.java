package algo;

public class ArrayTest7 {
    public static void main(String[] args) {
        int len = 5;
        int[][] ints = {
                {10, 13, 10, 12, 15},
                {12, 39, 30, 23, 11},
                {11 ,25, 50, 53, 15},
                {19 ,27, 29, 37, 27},
                {19 ,13, 30, 13, 19}
        };
        System.out.println(new ArrayTest7().solution(len,ints));


    }
    int solution(int len , int[][] ints){
        int row = 0;
        int line = 0;
        int max = 0;
        int temp = 0;
        int[] dia = new int[2];

        for(int i = 0; i < len ; i++){
            temp = max;
            for(int j = 0; j <len; j++){
                row += ints[i][j];
                line += ints[j][i];
            }

            dia[0] += ints[i][len-1-i];
            dia[1] += ints[i][i];

            max = Math.max(row,line);
            max = temp > max ? temp : max;
            row = 0;
            line = 0;
        }

        return lastMax(max,Math.max(dia[0],dia[1]));
    }

    int lastMax(int max , int dia){
        return Math.max(max,dia);
    }


}
