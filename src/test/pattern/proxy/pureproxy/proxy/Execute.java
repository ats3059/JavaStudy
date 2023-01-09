package test.pattern.proxy.pureproxy.proxy;

import test.pattern.proxy.pureproxy.proxy.code.CacheProxy;
import test.pattern.proxy.pureproxy.proxy.code.ProxyPatternClient;
import test.pattern.proxy.pureproxy.proxy.code.RealSubject;

import java.awt.event.ActionListener;

public class Execute {
    public static void main(String[] args) {
//        //프록시 적용전
//        ProxyPatternClient client = new ProxyPatternClient(new RealSubject());
//        //3초 소요
//        client.execute();
//        client.execute();
//        client.execute();
        //프록시 적용 후
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        // 기능을 추가했지만 ProxyPatternClient -> 클라이언트의 코드는 전혀 변경이 일어나지 않았다.

        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);
        // 이미 캐시가 되어있어서 속도를 1초소요
        client.execute();
        client.execute();
        client.execute();

        /*
            프록시 패턴의 핵심은 RealSubject 코드와 클라이언트 코드를 전혀 변경하지 않고, 프록시를 도입해서
            접근 제어를 했다는 점이다.
            그리고 클라이언트 코드의 변경 없이 자유롭게 프록시를 넣고 뺄 수 있다. 실제 클라이언트 입장에서는
            프록시 객체가 주입되었는지, 실제 객체가 주입되었는지 알지 못한다.
         */


    }
}
