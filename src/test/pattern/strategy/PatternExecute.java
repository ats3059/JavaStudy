package test.pattern.strategy;

import test.pattern.templatemethod.execute.TemplateMethod;

/*
    전략패턴
    템플릿 메서드 패턴의 상속 문제를 위임으로 해결한다.
    전략 패턴에서 Context 는 변하지 않는 템플릿 역할을 하고, Strategy 는 변하는 알고리즘 역할을 한다

    GOF 디자인 패턴에서 정의한 전략 패턴의 의도는 다음과 같다.
    > 알고리즘 제품군을 정의하고 각각을 캡슐화하여 상호 교환 가능하게 만들자. 전략을 사용하면 알고리즘을
    사용하는 클라이언트와 독립적으로 알고리즘을 변경할 수 있다.

    전략 패턴의 핵심은 Context 는 Strategy 인터페이스에만 의존한다는 점이다. 덕분에 Strategy 의
    구현체를 변경하거나 새로 만들어도 Context 코드에는 영향을 주지 않는다.

    이 방식의 단점은 Context 와 Strategy 를 조립한 이후에는 전략을 변경하기가 번거롭다는 점이다. 물론
    Context 에 setter 를 제공해서 Strategy 를 넘겨 받아 변경하면 되지만, Context 를 싱글톤으로
    사용할 때는 동시성 이슈 등 고려할 점이 많다.
    -> 해결책은 매개변수로 코드조각을 넘겨 받아서 Context가 execute()를 실행 시 파라미터로 넘어온 call()을 사용하게 하는 방법.


 */
public class PatternExecute {
    public static void main(String[] args) {
        //전략패턴 적용
        /*Context context = new Context(new StrategyImpl());
        context.execute();*/

        //인터페이스에 메서드가 1개라면 람다식 사용가능
        //익명 내부 클래스를 사용해도 가능하지만 그렇게하면 너무 코드가 길어짐.
    /*    Context lamda = new Context(()->{
            TemplateMethod.sleep(1000);
            System.out.println("실행2");
        });
        lamda.execute();*/

        //실행할 때 마다 전략을 유연하게 변경할 수 있다.
        //단점 역시 실행할 때 마다 전략을 계속 지정해주어야 한다는 점이다.
        Context context = new Context();
        context.execute(() -> System.out.println("실행3"));
        context.execute(() -> System.out.println("실행4"));



    }

    //변하는 알고리즘 역할을 한다.
    interface Strategy {
        public void call();
    }


    //전략패턴에서 Context(문맥)은 변하지 않는 것을 뜻한다.
    static class Context {
        private Strategy strategy;

        public Context() {
        }

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public void execute() {
            //부가적인 로직
            long startTime = System.currentTimeMillis();
            //핵심로직
            strategy.call();
            //핵심로직 end
            long endTime = System.currentTimeMillis();
            long executeTime = endTime - startTime;
            System.out.println("실행에 소요되는 시간 : " + executeTime);
        }

        // 콜백을 활용하는 전략패턴
        public void execute(Strategy strategy) {
            //부가적인 로직
            long startTime = System.currentTimeMillis();
            //핵심로직
            strategy.call();
            //핵심로직 end
            long endTime = System.currentTimeMillis();
            long executeTime = endTime - startTime;
            System.out.println("실행에 소요되는 시간 : " + executeTime);
        }
    }

    //해당 전략에 따라 바꿀 수 있는 변하는 부분의 구현체
    static class StrategyImpl implements Strategy {
        @Override
        public void call() {
            TemplateMethod.sleep(1000);
            System.out.println("실행1");
        }
    }

    static class StrategyImpl2 implements Strategy {
        @Override
        public void call() {
            TemplateMethod.sleep(1000);
            System.out.println("실행2");
        }
    }

}
