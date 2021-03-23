package demo1;

import java.util.concurrent.CountDownLatch;

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i=0;i<6;i++){
            new Thread(()->{
                System.out.println(countDownLatch.getCount()+"go out");
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println("关门");
    }
}
