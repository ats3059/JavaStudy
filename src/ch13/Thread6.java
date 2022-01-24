package ch13;

public class Thread6 extends Thread{
    int stock = 1000;

    public static void main(String[] args) {
        Thread thread1 = new Thread6();

        new Thread(thread1).start();
        new Thread(thread1).start();

    }



    @Override
    public void run() {
       while(stock > 0){
           stock = moneyStock(outMoney(),stock);
       }
    }

    int outMoney(){
        int out = (int)(Math.random() * 3 + 1) * 100;
        return out;
    }

    int moneyStock(int money , int stock){
        if(stock >= money){
            try{
                stock = stock - money;
                System.out.println(stock);
                Thread.sleep(1000);
            }catch (InterruptedException e) {

            }
        }else{
            System.out.println("잔고부족");
        }
        return stock;
    }

}
