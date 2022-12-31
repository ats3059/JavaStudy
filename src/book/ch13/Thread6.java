package book.ch13;


public class Thread6 implements Runnable {
    Account account = new Account();


    @Override
    public void run() {
        while (account.getStock() > 0) {
            System.out.println("남은돈" + account.getStock() + " " + account.moneyStock(account.outMoney(), account.getStock()));
        }
    }
}

class Start {
    public static void main(String[] args) {
        Runnable r = new Thread6();
        new Thread(r).start();
        new Thread(r).start();
    }

}

class Account {
    private int stock = 1000;

    public synchronized int getStock() {
        return stock;
    }

    int outMoney() {
        int out = (int) (Math.random() * 3 + 1) * 100;
        return out;
    }

    synchronized int moneyStock(int money, int stock) {
        if (stock >= money) {
            try {
                this.stock = stock - money;
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println(stock + " " + Thread.currentThread().getName());
        } else {
            System.out.println("잔고부족" + " " + stock + " " + Thread.currentThread().getName());
        }
        return stock;
    }
}