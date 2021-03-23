package demo2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            *//*try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*
            System.out.println(Thread.currentThread().getName() + "runAsync");
        });

        System.out.println("1111");
        completableFuture.get();*/

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "supplyAsync");
            int i = 10 / 0;
            return 1024;
        });

        System.out.println(completableFuture.whenComplete((u,v)->{
            System.out.println("u=>"+u);
            System.out.println("v=>"+v);
        }).exceptionally((e)->{
            System.out.println(e.getMessage());
            return 233;
        }).get());
    }
}
