package demo2;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo3 {
    //private static volatile int num=0;
    //volatile不保证原子性
    private volatile static AtomicInteger num=new AtomicInteger();

    public static void add(){
        //num++;
        num.getAndIncrement();//AtomicInteger的++方法
    }

    public static void main(String[] args) {

        for (int i=0;i<20;i++){
            new Thread(()->{
                for (int j=0;j<1000;j++){
                    add();
                }
            }).start();
        }

        while(Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(num);
    }
}
