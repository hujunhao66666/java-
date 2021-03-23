package demo1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        //test1();
        //test2();
        //test3();
        test4();
    }

    public static void test1(){
        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(3);

        System.out.println(queue.add("A"));
        System.out.println(queue.add("B"));
        System.out.println(queue.add("C"));
        //System.out.println(queue.add("D"));   队列已满，抛出异常
        System.out.println(queue.element());

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println(queue.element());//抛出异常的检测队首元素方法
        //System.out.println(queue.remove());   队列已空，抛出异常
    }

    public static void test2(){
        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(3);

        System.out.println(queue.offer("A"));
        System.out.println(queue.offer("B"));
        System.out.println(queue.offer("C"));
        System.out.println(queue.offer("D"));//不抛出异常，返回false

        System.out.println(queue.peek());

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());//返回null

        System.out.println(queue.peek());//返回null的检测队首元素的方法


    }

    public static void test3() throws InterruptedException {
        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(3);

        queue.put("A");
        queue.put("B");
        queue.put("C");
        //queue.put("D");   没有位置后会一直等待

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        //System.out.println(queue.take());   没有元素后会阻塞
    }

    public static void test4() throws InterruptedException {
        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(3);

        System.out.println(queue.offer("A"));
        System.out.println(queue.offer("B"));
        System.out.println(queue.offer("C"));
        System.out.println(queue.offer("D", 2, TimeUnit.SECONDS));//超时两秒后退出

        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.poll(2, TimeUnit.SECONDS));
        System.out.println(queue.poll(2, TimeUnit.SECONDS));//等待两秒后退出
    }
}


