package test.pattern.proxy.pureproxy.proxy.code;

public class RealSubject implements Subject{

    @Override
    public String operation() {
        System.out.println("실제 객체 호출");
        sleep(1000L);
        return "data";
    }

    private void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
