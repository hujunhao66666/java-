package demo4;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadLock implements Runnable{

    public static void main(String[] args) {
        ThreadLock t1 = new ThreadLock();
        Thread t2 = new Thread(t1);
        Thread t3 = new Thread(t1);
        Thread t4 = new Thread(t1);

        t2.start();
        t3.start();
        t4.start();
    }

    int ticketNum=10;

    private final ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();

                if (ticketNum <= 0) {
                    break;
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNum--);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
