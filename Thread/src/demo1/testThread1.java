package demo1;

//创建线程方法1
public class testThread1 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("线程"+i);
        }
    }

    public static void main(String[] args) {
        testThread1 testThread1 = new testThread1();
        //testThread1.start();
        testThread1.run();
        for (int i=0;i<20;i++){
            System.out.println("主线程"+i);
        }

    }
}
