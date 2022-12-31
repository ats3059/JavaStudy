package algo;
import java.util.*;
public class SortStudy {

    public static void main(String[] args) {
        new SortStudy().solution(new int[]{5,3,2,1,6,7,4,0});
    }
    public int solution(int[] citations) {
        int answer = 0;
        int size = citations.length;
//        bubbleSort(citations, size);
//        selectionSort(citations,size);
//        insertionSort(citations);
        mergeSort(citations);
        return answer;

    }

    private void bubbleSort(int[] citations, int size) {
        for(int j = 0; j < citations.length-1; j++){
            for (int i = 0; i < size -j-1; i++) {
                int front = citations[i];
                int back = citations[i+1];
                if(back < front){
                    citations[i] = back;
                    citations[i+1] = front;
                }
            }
        }
        printArray(citations);
    }

    private void selectionSort(int[] citations, int size) {
        for (int i = 0; i < size-1; i++) {
            int idx = i;
            for(int j = i+1; j < citations.length; j++){
                if(citations[j] < citations[idx]) idx = j;
            }
            int temp = citations[i];
            citations[i] = citations[idx];
            citations[idx] = temp;
        }
        printArray(citations);
    }

    private void insertionSort(int[] citations){
        for (int i = 1; i < citations.length; i++) {
            int temp = citations[i] ,j;
            for (j = i - 1; j >= 0; j--) {
                if(citations[j] > temp) citations[j+1] = citations[j];
                else break;
            }
            citations[j+1] = temp;
            printArray(citations);
        }
    }

    private void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mergeSort(arr,temp, 0 , arr.length-1);
        printArray(arr);
    }
    private void mergeSort(int[] arr , int[] tmp , int start , int end){
        if(start < end){
            int mid  = (start + end) / 2;
            mergeSort(arr,tmp , start , mid);
            mergeSort(arr,tmp,mid+1,end);
            merge(arr,tmp,start,mid,end);
        }
    }
    private void merge(int[] arr ,int[] tmp , int start , int mid , int end){
        for(int i = start; i <= end; i++){
            tmp[i] = arr[i];
        }

        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while(part1 <= mid  && part2 <= end){
            if(tmp[part1] >= tmp[part2]){
                arr[index] = tmp[part1];
                part1++;
            }else{
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for(int i = 0; i <= mid - part1; i++){
            arr[index + i] = tmp[part1 + i];
        }
    }


    private void printArray(int[] someArr){
        System.out.println(Arrays.toString(someArr));
    }



}
