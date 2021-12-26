package ch11;

import java.util.LinkedList;
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
            else if (str.equals("print")) print();
            else queue.offer(str);


            if(queue.size() > SIZE){
                queue.poll();
            }


        }

    }
    static void print(){

    }

}
