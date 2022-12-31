package book.ch11;

import java.util.Arrays;
import java.util.Comparator;

public class SortStudy {

    public static void main(String[] args) {
        int[] intArr = {6,0,3,8,7,1};

        for(int i = 0; i < intArr.length-1; i++){
            for(int j = 0; j < intArr.length-1-i; j++){
                int sw = 0;
                if(intArr[j] > intArr[j+1]){
                    sw = intArr[j+1];
                    intArr[j+1] = intArr[j];
                    intArr[j] = sw;
                }
            }
        }

        Arrays.sort(intArr);







        String[] str = {"hello","ab","cd","AB","CD"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
        Arrays.sort(str,String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(str));
        Arrays.sort(str , new Reverse());
        System.out.println(Arrays.toString(str));
    }


}

class Reverse implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Comparable && o2 instanceof Comparable){
            Comparable co1 = (Comparable)o1;
            Comparable co2 = (Comparable)o2;

            return co1.compareTo(co2) * -1;
        }
        return -1;
    }
}

