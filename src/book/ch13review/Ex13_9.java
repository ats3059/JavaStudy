package book.ch13review;

import javax.swing.*;

public class Ex13_9 {

    public static void main(String[] args) {
        ThreadEx9_1 th1 = new ThreadEx9_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt();
        System.out.println("isInterrupted() : " + th1.isInterrupted());

    }


}
class ThreadEx9_1 extends Thread{

    static void test(){
        System.out.println("!234");
    }


    @Override
    public void run() {
        int i = 10;

        while (i != 0 && !isInterrupted()) {
            System.out.println(i--);
            for(long x=0;  x<2500000000L; x++);
        }
        System.out.println("카운트가 종료되었습니다");
        System.out.println("isInterrupted()" + isInterrupted()); // true
        // isInterrupted()와 달리 interrupted()는 interrupted라는 상태변수를 false로 초기화한다.
        // -> 호출 시 지금 interrupt 상태인지 반환하고 그 후 false로 초기화해준다
        System.out.println("isInterrupted()" + Thread.interrupted()); // true
        //그래서 다음에 호출하는 경우 false출력
        System.out.println("isInterrupted()" + Thread.interrupted()); // false

    }
}
