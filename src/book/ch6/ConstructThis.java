package book.ch6;

public class ConstructThis {
//    생성자 this()
//    생성자에서 다른생성자 호출할때 사용
//    다른 생성자 호출시 첫 줄에서만 사용가능
//
//
//    참조변수 this != this() 생성자
//    인스턴스 자신을 가리키는 참조변수
//    인스턴스 메서드 (생성자포함)에서 사용가능
//    지역변수와 인스턴스 변수를 구별할 때 사용가능
//
//
//    this 인스턴스 자신을 가리키는 참조변수 , 인스턴스의 주소가 저장되어 있다.
//    모든 인스턴스 메서드에 지역변수로 숨겨진 채로 존재한다.
//
//    this() , this(매개변수) 생성자 , 같은 클래스의 다른 생성자를 호출 할 때 사용한다.

    String iv1;
    String iv2;

    ConstructThis(){
        this("인스턴스변수1","인스턴스변수2");
    }

    ConstructThis(String iv1, String iv2){
        this.iv1 = iv1;
        this.iv2 = iv2;

    }

}
