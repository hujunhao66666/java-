package demo3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        /*int num=10;
        while (num>=0){
            System.out.println(num--);
            Thread.sleep(1000);
        }*/

        DateTime();
    }

    public static void DateTime() throws InterruptedException {
        Date date = new Date(System.currentTimeMillis());

        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            date=new Date(System.currentTimeMillis());
        }
    }
}
