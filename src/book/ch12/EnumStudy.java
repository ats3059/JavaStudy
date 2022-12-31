package ch12;

import java.util.Scanner;

/*
열거형 (enum)
관련된 상수들을 같이 묶어 놓은 것 Java는 타입에 안전한 열거형을 제공

	Java의 열거형은 값 & 타입 모두 체크함.


	열거형의 정의와 사용
		enum 열거형 이름 {상수명1, 상수명2, ...}
		열거형 상수의 비교에 ==와 compareTo() 사용 가능

		비교연산자 사용불가
		compareTo 같으면 0 왼쪽크면 양수 오른쪽크면 음수

		Enum클래스 -> 모든 열거형의 조상
		모든 열거형은 Enum의 자손이며 , 아래의 메서드를 상속받는다.

		String name() 열거형 상수의 이름을 문자열로 반환
		int ordina() 열거형 상수가 정의된 순서를 반환(0부터 시작)
		T valueOf() 지정된 열거형에서 name과 일치하는 열거형 상수를 반환

		values() , valueOf()는 컴파일러가 자동으로 추가
		static E[] values()
		static E valueOf(String name)

		상수형에 들어가는 값은 하나하나가 객체다 -> 객체니까 비교연산자 사용불가.

열거형에 멤버 추가하기

	불연속적인 열거형 상수의 경우 , 원하는 값을 괄호()안에 적는다.
	여러개 가능
	enum Direction { EAST(1 , ">") , SOUTH(5) ,WEST(-1) , NORTH(10) };

	괄호()를 사용하려면 , 인스턴스 변수와 생성자를 새로 추가해 줘야 한다.
	//열거형에 값을 추가하려면 갯수만큼 iv를 추가해야함.
	private final int value; //정수를 저장할 필드(인스턴스 변수)를 추가
	Direction(int value){this.value = value;}//생성자도 추가해야함.
	public int getValue() {return value;}

	enum에서 생성자는 항상 private이다. 외부에서 객체생성 불가.
	Direction d = new Direction(1) // 에러. 열거형의 생성자는 외부에서 호출불가.
 */
enum Fruit{
    BANANA(500,"Banana"), BLUEBERRY(700,"BlueBerry") , GRAPE(600, "Grape");

    private final int pay;
    private final String fruit;
    private static final Fruit[] getEnum(){
        return Fruit.values();
    }
    Fruit(int pay , String fruit) {
        this.pay = pay;
        this.fruit = fruit;
    }

    public int getPay(){
        return pay;
    }

    public String getFruit(){
        return fruit;
    }
}


public class EnumStudy {
    public static void main(String[] args) {
        Fruit fruit2 = Fruit.BANANA;

        System.out.println(Fruit.BANANA);

        while(true){
            Order order = null;
            Scanner scanner = new Scanner(System.in);
            System.out.println("소지금입력.\n");
            int myMoney = Integer.valueOf(scanner.nextLine());

            System.out.println("입력해라.\n");
            String command = scanner.nextLine();

            if(command.equals("exit")) break;

            Fruit[] fruit = Fruit.values();

            for(Fruit element : fruit){
                if(command.equals(element.getFruit())){
                    order = Order.builder().product(element.getFruit()).pay(element.getPay()).build();
                }
            }

            if(order == null){
                System.out.println("잘못 입력했음.");
                break;
            }
            if(!Payment.payment(myMoney,order.getPay())) break;
            Mixer.mix(order);
            break;
        }
    }

}

class Order{
    private int pay;
    private String product;

    public String getProduct(){
        return product;
    }
    public int getPay(){
        return pay;
    }

    private Order(Builder builder){
        this(builder.pay,builder.product);
    }

    private Order(int pay, String product){
        this.pay = pay;
        this.product = product;
    }
    public static Builder builder(){
        return new Builder();
    }

    static class Builder{
        private int pay;
        private String product;

        public Builder pay(int value){
            pay = value;
            return this;
        }

        public Builder product(String value){
            product = value;
            return this;
        }

        public Order build(){
            return new Order(this);
        }
    }
}

class Payment{
    public static boolean payment(int myMoney , int productPrice){
        if(productPrice > myMoney){
            System.out.println("소지금 부족");
            return false;
        }else{
            System.out.println("주스 만들거야.");
            return true;
        }
    }

}

class Mixer{
    public static void mix(Order order){
        System.out.println(String.format("갈거야 과일. %s",order.getProduct()));
    }
}




