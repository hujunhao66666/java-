package demo1;

//创建线程方法2
public class testThread2 implements Runnable {
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println("子线程---------------"+i);
        }
    }

    public static void main(String[] args) {
        testThread2 testThread2 = new testThread2();

        Thread thread = new Thread(testThread2);

        thread.start();

        for (int i=0;i<20;i++) {
            System.out.println("主线程============"+i);
        }
    }
}
