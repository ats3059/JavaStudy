package ch13review;

import java.util.ArrayList;

public class Ex13_15 {
    public static void main(String[] args) throws Exception{
       Table table = new Table();

        new Thread(new Cook(table), "COOK1").start();
        new Thread(new Customer(table, "donut"),  "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();
        new Thread(new Customer(table, "donut"), "CUST3").start();

        Thread.sleep(2000);
        System.exit(0);
    }

}

class Customer implements Runnable{
    private Table table;
    private String food;

    public Customer(Table table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e){}
            String name = Thread.currentThread().getName();
            table.remove(food);
            System.out.println(name + " ate a" + food);
        }

    }


}

class Cook implements Runnable {
    private Table table;

    public Cook(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while(true){
            int idx = (int) (Math.random() * table.getDishLen());
            table.add(table.dishNames[idx]);
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e){}
        }
    }
}

class Table {
    String[] dishNames = {"donut","donut","burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public int getDishLen(){
        return dishNames.length;
    }

    public synchronized void add(String dish) {
        while (dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name + "is waiting");
            try {
                wait();
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        dishes.add(dish);
        notify(); // 기다리고 있는 소비자를 깨우기위함 ( 쓰레드 )
        System.out.println("Dishes:" + dishes.toString());
    }

    public void remove(String dishName){

        synchronized(this){
            String name = Thread.currentThread().getName();

            while(dishes.size()==0){
                System.out.println(name + "is waiting");
                try {
                    wait();
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }

            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if(dishName.equals(dishes.get(i))){
                        dishes.remove(i);
                        notify(); // 잠자고 있는 COOK을 깨우기 위함
                        return;
                    }
                    try {
                        System.out.println(name+" is waiting.");
                        wait(); // 원하는 음식이 없는 CUST쓰레드를 기다리게 한다.
                        Thread.sleep(500);
                    } catch(InterruptedException e) {}
                }
            }
        }
    }



}



