package book.ch13review;

public class Ex13_12 {

    public static void main(String[] args) {
        Runnable r = new RunnableEx12();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
    }

}

class Account{
    private int balance = 1000;


    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int money){
        if(balance >= money){
            sleep();
            balance -= money;
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }
}

class RunnableEx12 implements Runnable {
    Account acc = new Account();
    @Override
    public void run() {
        while (acc.getBalance() > 0) {
            int money = (int)(Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance : " + acc.getBalance());
        }
    }
}

