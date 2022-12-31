package book.ch13;


import java.util.ArrayList;
import java.util.List;

public class Thread7 implements Runnable {
    public String menuName;
    public List<String> table = new ArrayList();
    private static int MAX_ORDER = 3;
    private static String[] menu = {"pizza", "coke", "pizza"};

    public Thread7() {
        super();
    }

    public Thread7(String value) {
        menuName = value;
    }

    @Override
    public void run() {
        while (true) {
            order();
            eat();
        }
    }

    public int random() {
        int randomValue = (int) (Math.random() * 3);
        return randomValue;
    }

    public synchronized void order() {
        if (MAX_ORDER > table.size()) {
            table.add(menu[random()]);
            System.out.println(table);
            notify();
        } else {
            try {
                wait();
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
            System.out.println("cook = " + "wait");
        }
    }

    public synchronized void eat() {
        if (table.indexOf(menuName) > -1) {
            for (int i = 0; i < table.size(); i++) {
                if (menuName.equals(table.get(i))) {
                    System.out.println(String.format("Cust = %s" , table));
                    table.remove(i);
                    notify();
                }
            }
        } else{
            try {
                System.out.println("cust food is empty");
                wait();
            } catch (InterruptedException e) {

            }
        }
    }

    public String getThreadName() {
        return Thread.currentThread().getName();
    }

}

class StartThread7 {
    public static void main(String[] args) throws Exception{
        new Thread(new Thread7("pizza"), "cust1").start();
        new Thread(new Thread7("pizza"), "cust2").start();
//        new Thread(new Thread7("pizza"), "cust3").start();
//        new Thread(new Thread7("pizza"), "cust4").start();
//        new Thread(new Thread7("pizza"), "cust5").start();
//        new Thread(new Thread7("coke"), "cust6").start();
        new Thread(new Thread7(), "cook").start();
        Thread.sleep(5000);
        System.exit(0);


    }
}
