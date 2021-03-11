package demo1;

import java.util.concurrent.*;

//创建线程方法3
public class testThread4 implements Callable<Boolean> {
    private String name;

    public testThread4(String name){
        this.name=name;
    }

    @Override
    public Boolean call() throws Exception {
        for(int i=0;i<20;i++) {
            System.out.println(this.name + "执行了");
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testThread4 test1 = new testThread4("小明");
        testThread4 test2 = new testThread4("小红");
        testThread4 test3 = new testThread4("小刚");

        //创建执行服务
        ExecutorService service= Executors.newFixedThreadPool(2);

        //提交执行
        Future<Boolean> r1 = service.submit(test1);
        Future<Boolean> r2 = service.submit(test2);
        Future<Boolean> r3 = service.submit(test3);

        //获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        //关闭服务
        service.shutdown();

    }
}
