package demo4;

public class UnsafeBuyTicket {
    public static void main(String[] args) {
        Buyticket buyticket = new Buyticket();
        Thread t1 = new Thread(buyticket,"小明");
        Thread t2 = new Thread(buyticket,"黄牛");
        Thread t3 = new Thread(buyticket,"我");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Buyticket implements Runnable{
    private int ticketNum=10;
    boolean flag=true;
    private Object lock=new Object();

    @Override
    public void run() {
        while (flag) {
            //safeBuy();
            
            synchronized (lock) {
                safeBuy1();
            }
        }
    }

    public void buy() throws InterruptedException {
        if (ticketNum<=0){
            flag=false;
            return ;
        }else{
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"买到第"+ticketNum+"张票");
            ticketNum--;
        }
    }

    public synchronized void safeBuy(){
        if (ticketNum<=0){
            flag=false;
            return ;
        }else{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"买到第"+ticketNum+"张票");
            ticketNum--;
        }
    }

    public  void safeBuy1(){
        if (ticketNum<=0){
            flag=false;
            return ;
        }else{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"买到第"+ticketNum+"张票");
            ticketNum--;
        }
    }
}