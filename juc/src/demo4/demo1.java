package demo4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class demo1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.temp1();
        },"A").start();

        new Thread(()->{
            phone.temp1();
        },"B").start();


    }
}

class Phone{
    Lock lock=new ReentrantLock();

    public void temp1(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "=>1");
            call();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void call(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"==>2");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}