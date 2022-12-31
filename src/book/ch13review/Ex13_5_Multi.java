package book.ch13review;

import javax.swing.*;

public class Ex13_5_Multi {
    public static void main(String[] args) {
        ThreadTest7_1 t1 = new ThreadTest7_1();
        t1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력하신 값은 " + input + "입니다.");

    }
}


class ThreadTest7_1 extends Thread {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
       }
    }
}