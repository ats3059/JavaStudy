package ch12;

import java.util.Scanner;

enum Fruit{
    BANANA(500,"Banana"), BLUEBERRY(700,"BlueBerry") , GRAPE(600, "Grape");

    private final int pay;
    private final String fruit;

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




