package demo1;


public class testThread3 implements Runnable{

    private int ticketNums=10;

    @Override
    public void run() {
        while (true){
            if (ticketNums <= 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName()+"---------->拿到了第"+ticketNums+"张票");
            ticketNums--;
        }
    }

    public static void main(String[] args) {
        testThread3 testThread3 = new testThread3();

        new Thread(testThread3,"小明").start();
        new Thread(testThread3,"小红").start();
        new Thread(testThread3,"小刚").start();
    }
}
