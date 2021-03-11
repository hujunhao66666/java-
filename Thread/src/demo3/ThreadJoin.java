package demo3;

//测试join方法
public class ThreadJoin implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"线程来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin,"A");

        thread.start();

        for (int i=0;i<100;i++){
            if (i==50){
                thread.join();
            }
            System.out.println("主线程"+i);
        }
    }
}
