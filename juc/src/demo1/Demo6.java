package demo1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo6 {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i=0;i<6;i++){
            final int temp=i;
            new Thread(()->{
                myCache.write(temp+"",temp);
            },temp+"").start();
        }

        for (int i=0;i<6;i++){
            final int temp=i;
            new Thread(()->{
                myCache.read(temp+"");
            },temp+"").start();
        }


    }
}

class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

    public void read(String key){
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName()+"读取了"+key);
        map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取完成");
        lock.readLock().unlock();
    }

    public void write(String key,Object value){
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName()+"写入了"+key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入完成");
        lock.writeLock().unlock();
    }
}
