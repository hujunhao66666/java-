package demo4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        //ExecutorService pool = Executors.newFixedThreadPool(3);
        ExecutorService pool = Executors.newFixedThreadPool(5);
        /*四种线程池*/
        /*Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool();
        Executors.newSingleThreadExecutor();



        pool.submit(new MyThread());
        pool.submit(new MyThread());
        pool.submit(new MyThread());
        pool.submit(new MyThread());
        pool.submit(new MyThread());

        pool.shutdown();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
