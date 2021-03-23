package demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Data2 data2 = new Data2();
        new Thread().start();
        FutureTask futureTask = new FutureTask(data2);
        new Thread(futureTask,"A").start();
        int o = (int) futureTask.get();
        System.out.println(o);
    }
}

class Data2 implements Callable{

    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 1024;
    }
}
