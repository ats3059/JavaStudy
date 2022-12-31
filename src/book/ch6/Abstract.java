package book.ch6;

public class Abstract {

    public static void main(String[] args) {

        Unit[] unitArr = new Unit[3];
        unitArr[0] = new Marine();
        unitArr[1] = new Tank();
        unitArr[2] = new DropShip();

        //Repair
        for (Unit unit : unitArr) {
            if (unit instanceof Repair) {
                Repair repair = (Repair) unit;
                while (unit.hp < 100) {
                    ++unit.hp;
                }
                repair.repair();
            }
            unit.move();
            unit.stop();
        }

    }
}

abstract class Unit {
    int x, y, hp;

    Unit() {

    }

    Unit(int x, int y, int hp) {
        this.x = x;
        this.y = y;
        this.hp = hp;
    }

    abstract void move();

    void stop() {
        System.out.println("멈추다");
    }

}

abstract class GroundUnit extends Unit {
    GroundUnit() {

    }

    GroundUnit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    GroundUnit(int x, int y, int hp) {
        super(x, y, hp);
    }
}

abstract class AirUnit extends Unit {
    AirUnit() {

    }

    AirUnit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    AirUnit(int x, int y, int hp) {
        super(x, y, hp);
    }
}

interface Repair {
    void repair();
}

class Marine extends GroundUnit {
    Marine() {
        super(100, 100);
    }

    @Override
    void move() {
        System.out.println("마린이 움직임 " + x + y);
    }

}

class Tank extends GroundUnit implements Repair {
    Tank() {
        super(200, 100, 50);
    }

    @Override
    void move() {
        System.out.println("탱크가 움직임 " + x + y);
    }

    @Override
    public void repair() {
        System.out.println("탱크의 수리가 완료되었습니다.");
    }

}

class DropShip extends AirUnit implements Repair {
    DropShip() {
        super(200, 100, 50);
    }

    @Override
    void move() {
        System.out.println("드랍쉽이 움직임 " + x + y);
    }

    @Override
    public void repair() {
        System.out.println("드랍쉽의 수리가 완료되었습니다.");
    }
}




