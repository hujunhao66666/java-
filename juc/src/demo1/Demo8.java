package demo1;

import java.util.concurrent.SynchronousQueue;

public class Demo8 {
    public static void main(String[] args) {
        SynchronousQueue<String> queue = new SynchronousQueue<String>();

        new Thread(()->{
            for (int i=0;i<10;i++){
                final int temp=i;
                try {
                    queue.put(temp+"");
                    System.out.println(Thread.currentThread().getName()+"放入了"+temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i=0;i<10;i++){
                if (queue.isEmpty()){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String temp = queue.poll();
                System.out.println(Thread.currentThread().getName()+"取出了"+temp);
            }
        },"B ").start();


    }
}
