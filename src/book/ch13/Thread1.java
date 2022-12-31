package ch13;

/*
프로세스와 스레드

프로세스 : 실행 중인 프로그램 , 자원과 쓰레드로 구성
쓰레드 : 프로세스 내에서 실제 작업을 수행
모든 프로세서는 최소한 하나의 쓰레드를 가지고 있다.

프로세스 : 쓰레드 = 공장 : 일꾼

싱글 쓰레드 프로세스
자원 + 쓰레드

멀티 쓰레드 프로세스

하나의 새로운 프로세스를 생성하는 것보다
하나의 새로운 쓰레드를 생성하는 것이 더 적은 비용이 든다.



멀티쓰레드의 장단점
대부분의 프로그램이 멀티쓰레드로 작성되어 있다.
	장점 : 시스템 자원을 보다 효율적으로 사용할 수 있다.
	사용자에 대해 응답성이 향상된다.
	작업이 분리되어 코드가 간결해 진다.
	"여러 모로 좋다"

	단점 : 동기화에 주의해야 한다.
		교착상태가 발생하지 않도록 주의해야한다.
		각 쓰레드가 효율적으로 고르게 실행될 수 있게 해야한다.
		기아상태 : 쓰레드가 여러개니까 어떤 쓰레드는 자신이 실행 할 기회가 주어지지 않고 죽는다.
		"프로그래밍할 떄 고려해야 할 사항들이 많다."


	쓰레드의 구현과 실행
	1.Thread 클래스를 상속


	//인터페이스를 구현하는게 낫다.
	2.Runnable 인터페이스를 구현

	run() -> 쓰레드가 수행할 작업을 작성.

	start() -> 즉시실행되는게 아님 , 먼저 start()호출했다고 먼저 시작하는게 아님(무조건)
	쓰레드는 OS의 스케줄러가 실행순서 결정한다.

	쓰레드는 OS에 의존적이다... -> JVM이 OS에서 독립적이라고는 하지만 종속적인게 몇가지 있는데 그 중 하나가 쓰레드이다.



	run()을 작성했는데 왜 start()를 호출하는가
		=> run()을 호출한다면 그냥 해당 쓰레드(메인)에서 run()을 스택에 올려서 호출한 것.
			-> 쓰레드가 2개가 아님 그냥 main에서 run()메서드 호출시킨거.
		=> start() 호출 시
			쓰레드 생성 -> 쓰레드니까 자신만의 호출스택 생성됨 -> 해당 스택에 run()메서드 올리면서 독립적인 실행가능


 */
public class Thread1 {
    public static void main(String[] args) {
        ThreadFirst thread = new ThreadFirst();
        Runnable runnable = new ThreadSecond();

        Thread threadSec = new Thread(runnable);

        thread.start();
        threadSec.start();


    }

}


class ThreadFirst extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 500; i++){
            System.out.print(0);
        }
    }
}

class ThreadSecond implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 500; i++){
            System.out.print(1);
        }
    }
}
