package demo4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class demo2 {
    public static void main(String[] args) {
        Phone2 phone2 = new Phone2();

        for (int i=0;i<2;i++){
            final String temp=i+"";
            new Thread(()->{
                phone2.mylock();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    phone2.unlock();
                }
            },temp).start();
        }
    }
}

class Phone2{
    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    public void mylock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"加锁");
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"解锁");
        atomicReference.compareAndSet(thread,null);
    }
}
