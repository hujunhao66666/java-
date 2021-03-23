package demo2;

import java.util.concurrent.TimeUnit;

public class VolatileDemo2 {
    //private static int num=0;
    private volatile static int num=0;//不加volatile，程序会死循环
    //volatile保证原子性

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num==0){

            };
        }).start();

        TimeUnit.SECONDS.sleep(2);
        num=1;
        System.out.println(num);
    }
}
