package book.ch6;

public class Polymorphism {
    public static void main(String[] args) {
        Buyer buyer = new Buyer();
        buyer.buy(new Computer());
        buyer.buy(new Tv1());
    }
}

class Product{
    int money;
    int bonus;
    int price;
    String goodsName;
    Product(int money ,int price ,String goodsName){
        this.money = money;
        this.price = price;
        this.goodsName = goodsName;
    }

    public int getBonus(){
        return this.bonus = (int)price/10;
    }
}

class Tv1 extends Product{
    Tv1(){
        super(200,100,"TV");
    }
}

class Computer extends Product{
    Computer(){
        super(100,50,"COMPUTER");
    }

}

class Buyer{
    void buy(Product p){
        System.out.println("goodsName " + p.goodsName);
        System.out.println("result" + (p.money - p.price));
        System.out.println("Bonus " + p.getBonus());
    }
}

/*
다형성
 여러 가지 형태를 가질 수 있는 능력
 조상 타입 참조 변수로 자손타입 객체를 다루는 것

 다형성 장점 2가지


참조 변수의 형변환

기본형의 형변환 -> 값이 바뀐다

사용할 수 있는 멤버의 갯수를 조절하는 것
조상 자손 관계의 참조변수는 서로 형변환 가능

instanceof 연산자
	형변환 시 반드시 형변환 가능한지 확인하고 변환
	참조변수의 형변환 가능 여부 확인에 사용 . 가능하면 true 반환

참조변수의 형변환은 왜하나요?
	참조변수(리모콘)을 변경함으로써 사용할 수 있는 멤버의 갯수를 조절하기 위해서


 */
