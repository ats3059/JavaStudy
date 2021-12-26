package ch11;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class QueueStudy {
    static final int SIZE = 5;
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        while(true){

            String str = scanner.nextLine();

            if(str.equals("q")){
                break;
            }
            if("".equals(str)) continue;
            else if (str.equals("print")) print((LinkedList)queue);
            else queue.offer(str);


            if(queue.size() > SIZE){
                queue.poll();
            }


        }

    }
    static void print(List list){
        for(int i = 0; i < SIZE; i++){
            System.out.println(list.get(i));
        }
    }

}
