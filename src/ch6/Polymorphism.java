package ch6;

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


