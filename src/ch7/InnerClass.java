package ch7;

/*
내부 클래스의 장점
 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다.

 내부클래스에서 객체 생성없이 A의 멤버 접근 가능
 코드의 복잡성을 줄일 수 있다. (캡슐화)

 상수는 따로 Constant pool에서 관리되고 있어서 메서드 종료 후에도 사용가능

 내부클래스는 컴파일하면 OuterClass$InnerClass.class 이런식으로 외부클래스명 + $가 붙는다
 (메서드)지역클래스라면 -> 다른 클래스에도 메서드 내부에 같은 이름의 내부클래스가 존재할 수 있어서 OuterClass$1LInnerClass.class 구분값이 붙는다 (1L)


익명클래스
	이름이 없는 일회용 클래스 , 정의와 생성을 동시에
	조상클래스이름 OR 구현인터페이스이름 사용

 */

public class InnerClass {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.new InnerTestClass();
        outerClass.method();

        //익명 클래스 (한 번만 사용가능)
        TestInterface testInterface = new TestInterface(){
            @Override
            public void testMethod() {
                System.out.println(1234);
            }
        };

        TestInterface testInterface1 = new TestInterface(){
            @Override
            public void testMethod() {
                System.out.println(1234);
            }
        };
    }

}

interface TestInterface{
    void testMethod();
}

class OuterClass{

    private int x = 0;
    static int y = 0;


    //인스턴스 클래스
    class InnerTestClass{

        void method(){
            //장점 외부클래스의 프라이빗 접근가능
            x = 5;
        }
    }

    //스태틱 클래스
    static class InnerTestClass2{


    }


    void method(){
        //메서드 내부의 지역 클래스
        class InnerTestClass3{
            int x = 1;
        }
        InnerTestClass3 innerTestClass3 = new InnerTestClass3();
    }


}
