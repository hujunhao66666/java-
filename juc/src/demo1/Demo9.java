package demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Demo9 {
    public static void main(String[] args) {
        //ExecutorService service = Executors.newSingleThreadExecutor();
        //ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        ExecutorService service = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 10; i++) {
                service.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "ok");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }finally {
            service.shutdown();
        }
    }
}
