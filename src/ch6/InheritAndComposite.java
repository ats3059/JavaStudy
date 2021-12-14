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