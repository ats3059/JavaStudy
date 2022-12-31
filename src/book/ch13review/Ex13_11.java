package book.ch13review;

public class Ex13_11 {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Thread thread = new Thread(new TimeThread());
        Thread thread2 = new Thread(new TimeThread2());

        thread.start();
        thread2.start();

        try {
            thread.join(); // main 쓰레드가 th1의 작업이 끝날 때까지 기다린다.
            thread2.join(); // main 쓰레드가 th2의 작업이 끝날 때까지 기다린다.
        } catch (InterruptedException e) {

        }
        System.out.println();
        System.out.println(String.format("종료시간(ms) = %s" , (System.currentTimeMillis() - start)));



    }


}

class TimeThread implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.print("|");
        }

    }
}

class TimeThread2 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.print("-");
        }

    }
}
