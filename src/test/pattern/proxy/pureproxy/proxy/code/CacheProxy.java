package test.pattern.proxy.pureproxy.proxy.code;

public class CacheProxy implements Subject{

    private Subject target;
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        System.out.println("프록시 호출");
        if(cacheValue == null) cacheValue = target.operation();
        return cacheValue;
    }
}
