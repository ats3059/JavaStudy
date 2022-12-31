package ch6;

public class InheritAndComposite {
    public static void main(String[] args) {
        //상속받은 관계
//        Circle circle = new Circle();
//        circle.x = 20;
//        circle.y = 30;
//        circle.r = 10;

        Circle circle = new Circle();
        circle.myPoint.x = 20;
        circle.myPoint.y = 30;
        circle.r = 10;
    }

}

class MyPoint{
    int x;
    int y;
}

//상속관계
//서클은 마이포인트의 상속관계이다
//class Circle extends MyPoint{
//    int r;
//}

//포함관계
//멤버변수로 myPoint 를 포함하고있다
//Circle 는 MyPoint 를 포함한다.
class Circle {

    MyPoint myPoint = new MyPoint();
    int r;
}



// super -> 조상의 멤버변수와 현재 클래스의 멤버변수를 구별할 때 사용



// 참조변수 super
// 객체 자신을 가리키는 참조변수 


// 추가조건

// 생성자의 첫 줄에 반드시 생성자를 호출해야한다.
// 그렇지 않으면 컴파일러가 생성자의 첫 줄에 super();를 삽입

// 모든 생성자는 첫줄에 다른 생성자를 호출해야한다 -> 안하면 자동으로 상속받은 조상클래스의 생성자를 호출함  


// 패키지

// 서로 관련된 클래스의 묶음
// 클래슨는 클래스파일,  패키지는 폴더  . 하위 패키지는 하위 폴더
// 클래스의 실제 이름은 패키지를 포함



// 9버전부터 모듈 개념으로 바뀌면서 사라짐
// rt.jar 
// runtime 실행할때 실행중 


// 패키지의 선언

// 패키지는 소스파일의 첫 번째 문장으로 단 한번 선언
// 같은 소스 파일의 클래스들은 모두 같은 패키지에 속하게 된다.
// 패키지 선언이 없으면 이름없는 패키지에 속하게 된다.


// 클래스 패스

// 클래스 파일의 위치를 알려주는 경로
// 환경변수 classpath로 관리하며 , 경로간의 구분자는 ';'를 사용
// classpath에 패키지의 루트를 등록해줘야함.
