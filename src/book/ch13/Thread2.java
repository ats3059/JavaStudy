package book.ch13;

public class Thread2 {
/*
        쓰레드 2
        쓰레드는 사용자 쓰레드와 데몬 쓰레드 두 종류가 있다.

        .join() 사용 시 해당 쓰레드가 끝날때까지 기다린다.

        프로세스와 쓰레드는 os에서 할당해줌 -> 우리가 커스텀할 수 없다.

        A쓰레드에서 B쓰레드로 넘어가는 행동을 Context Switching(문맥전환)이라고 한다.

    쓰레드의 I/O 블락킹(blocking) Input/Output 입력 / 출력 = 입출력 막힘
        -> 입출력시 작업중단


    쓰레드3

        쓰레드의 우선순위

        작업의 중요도에 따라 쓰레드의 우선순위를 다르게 하여 특정 쓰레드가 더 많은 작업시간을 갖게 할 수 있다.

        OS에서 돌아가는 프로세스 , 쓰레드들을 무시하고 우리가 실행하는 프로그램에만 특혜를 줄 수 없다. ( 우선순위란 희망순위이다. 걍 참고용.)

        우선순위 정해주는 메서드 .setPriority(int value) 기본값 5 ( 우선순위가 높은 쓰레드가 먼저 끝나게되어있다. (무조건은 아님)) 크게 기대하지 말어라...??
        왜 쓰는거야 그러면

    쓰레드 그룹
     - 서로 관련된 쓰레드를 그룹으로 묶어서 다루기 위한 것
     - 모든 쓰레드는 반드시 하나의 쓰레드 그룹에 포함되어 있어야 한다.
     - 쓰레드 그룹을 지정하지 않고 생성한 쓰레드는 main쓰레드 그룹에 속한다.
     - 자신을 생성한 쓰레드(부모 쓰레드)의 그룹과 우선순위를 상속 받는다.
 */

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Thread thread = new Thread(new TimeThread());
        Thread thread2 = new Thread(new TimeThread2());

        thread.start();
        thread2.start();

        try {
            thread.join();
            System.out.println(String.format("쓰레드1 종료시간(ms) = %s" , (System.currentTimeMillis() - start)));
            thread2.join();
            System.out.println(String.format("쓰레드2 종료시간(ms) = %s" , (System.currentTimeMillis() - start)));
        } catch (Exception e) {
            System.out.println("문제가 있는거야 이건.");
        }




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