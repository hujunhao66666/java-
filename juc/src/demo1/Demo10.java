package demo1;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo10 {
    public static void main(String[] args) {
        //最大线程数如何定义
        //CPU密集型 CPU几核就是几
        //IO密集型   判断你的任务中十分耗费IO的线程有多少个，只要大于这个数值即可
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors(),//获取CPU的核数
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),//候客区
                Executors.defaultThreadFactory(),//线程工厂
                //new ThreadPoolExecutor.AbortPolicy()//拒绝策略
                //new ThreadPoolExecutor.CallerRunsPolicy()
                //new ThreadPoolExecutor.DiscardOldestPolicy()
                new ThreadPoolExecutor.DiscardPolicy()
        );

        try{
            for(int i=0;i<10;i++){
                pool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"ok");
                });
            }
        }finally {
            pool.shutdown();
        }
    }
}
