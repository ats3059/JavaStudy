package book.ch13;

import java.util.Scanner;

public class Thread4 extends Thread{
/*
	sleep()
	- 현재 쓰레드를 지정된 시간동안 멈추게 한다.
	- 예외처리를 해야한다. Intrrupt하면 깨어남.(예외발생)
	- 특정 쓰레드를 지정해서 멈추게 하는 것은 불가능하다.

	interrupt()

	- 대기상태(WATING)인 쓰레드를 실행대기 상태(RUNNABLE)로 만든다.

	void interrupt()	쓰레드의 interrupted 상태를 false에서 ture로 변경.
	boolean isInterrupted() 쓰레드의 interrupted 상태를 반환.
	static boolean interrupted() 현재 쓰레드의 interrupted 상태를 알려주고, false로 초기화
 */
    public static void main(String[] args) {
        Thread th1 = new Thread4();
        Scanner sc = new Scanner(System.in);
        th1.start();
        System.out.println("입력하시오");
        if(sc.nextLine().equals("e")) th1.interrupt();
        
        

    }

    @Override
    public void run() {
        int i = 10;

        while (i!=0 && !isInterrupted()){
            System.out.println(isInterrupted());
            System.out.println(String.format("Count = %d" , --i));
            for(long j = 1L; j < 2500000000L; j++);
        }
        System.out.println("프로그램 종료");

    }



}



