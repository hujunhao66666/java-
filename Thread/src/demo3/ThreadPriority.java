package demo3;

public class ThreadPriority extends Thread{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"---->"+Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);

        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(MAX_PRIORITY);
        t4.start();

        t5.setPriority(MIN_PRIORITY);
        t5.start();

    }

}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---->"+Thread.currentThread().getPriority());
    }
}