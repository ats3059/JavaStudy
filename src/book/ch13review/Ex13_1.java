package book.ch13review;

import java.util.stream.IntStream;

public class Ex13_1 {
    public static void main(String[] args) {
        ThreadEx_1 thread1 = new ThreadEx_1(); // 쓰레드 thread1를 생성한다.
        Runnable threadEx2 = new ThreadEx_2();
        Thread thread2 = new Thread(threadEx2); // // 쓰레드 thread2를 생성한다.

        thread1.start(); // 쓰레드 thread1을 실행한다.
        thread2.start(); // 쓰레드 thread2을 실행한다.

    }



}

class ThreadEx_1 extends Thread{
    @Override
    public void run() {
        IntStream.range(0,500).forEach((x) -> System.out.println(this.getName()));
    }
}

class ThreadEx_2 implements Runnable{
    @Override
    public void run() {
        //Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
        IntStream.range(0,500).forEach((x) -> System.out.println(Thread.currentThread().getName()));
    }
}