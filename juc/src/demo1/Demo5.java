package demo1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Demo5 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i=0;i<6;i++){
            final int temp=i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到了车位");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName()+"离开了车位");
                    semaphore.release();
                }
            },String.valueOf(temp)).start();
        }
    }
}
