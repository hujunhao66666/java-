package demo3;

//测试礼让进程
//礼让不一定成功
public class ThreadYield {
    public static void main(String[] args) {
        MyYield t1 = new MyYield();


        new Thread(t1,"a").start();
        new Thread(t1,"b").start();
    }
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程结束");

    }
}