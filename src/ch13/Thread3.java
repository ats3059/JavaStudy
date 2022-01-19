package ch13;

public class Thread3 implements Runnable {
    /*
        데몬 쓰레드
        - 일반 쓰레드의 작업을 돕는 보조적인 역할을 수행.
        - 일반 쓰레드가 모두 종료되면 자동적으로 종료된다.
        - 가비지 컬렉터 , 자동저장, 화면 자동갱신 등에 사용된다.
        - 무한루프와 조건문을 이용해서 실행 후 대기하다가 특정조건이 만족되면 작업을 수행하고 다시 대기하도록 작성한다.


        setDaemon(boolean on)은 반드시 start()를 호출하기 전에 실해되어야 한다.
        그렇지 않으면 illegalThreadException이 발생한다.

        Thread.start() 이후 .setDaemon 호출하면 안됨 -> 예외발생

    쓰레드의 상태

        NEW  쓰레드가 생성되고 아직 START()가 호출되지 않은 상태
        RUNNABLE 실행중 또는 실행 가능한 상태
        BLOCKED 동기화블럭에 의해서 일시정지된 상태(lock이 풀릴 때까지 기다리는 상태)
        WAITING , TIMED_WAITING 쓰레드의 작업이 종료되지는 않았지만 실행가능하지 않은 일시 정지 상태, TIMED_WAITING은 일시정지 시간이 지정된 경우를 의미
        TERMINATED 쓰레드의 작업이 종료된 상태

    쓰레드의 실행제어

        쓰레드의 실행을 제어할 수 있는 메서드가 제공된다.

     */
    static boolean autoSave = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Thread3());
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);
                if (i + 1 == 5) autoSave = true;
                System.out.println(String.format("현재 시간은 = %d", i + 1));
            } catch (Exception e) {

            }

        }


        System.out.println("시스템 종료");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {

            }
            if (autoSave) System.out.println("자동저장 완료");
        }
    }
}
