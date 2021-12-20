package ch6;

import java.util.Arrays;

public class Abstract {

    public static void main(String[] args) {

        Unit[] unitArr = new Unit[3];
        unitArr[0] = new Marine();
        unitArr[1] = new Tank();
        unitArr[2] = new DropShip();
        Arrays.stream(unitArr).forEach((value) -> value.move());
    }
}
abstract class Unit{
    int x , y;

    Unit(int x,int y){
        this.x = x;
        this.y = y;
    }

    abstract void move();
    void stop(){
        System.out.println("멈추다");
    };
}

class Marine extends Unit{
    Marine(){
        super(100,100);
    }
    @Override
    void move() {
        System.out.println("마린이 움직임 " + x + y);
    }
}

class Tank extends Unit{
    Tank(){
        super(200,100);
    }
    @Override
    void move() {
        System.out.println("탱크가 움직임 " + x + y);
    }
}

class DropShip extends Unit{
    DropShip(){
        super(200,100);
    }
    @Override
    void move() {
        System.out.println("드랍쉽이 움직임 " + x + y);
    }
}

