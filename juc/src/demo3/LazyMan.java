package demo3;

//懒汉式单例
public class LazyMan {
    private LazyMan(){
        System.out.println(Thread.currentThread().getName()+"启动了");
    }

    private volatile static LazyMan lazyMan;

    //双重检测锁模式的 懒汉式单例 DCL懒汉式
    public static LazyMan getInstance(){
        //加锁
        if (lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan==null){
                    lazyMan = new LazyMan();
                }
            }
        }

        return lazyMan;
    }
    //单线程下懒汉式可以，但是并发编程不可以
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                lazyMan.getInstance();
            }).start();
        }
    }
}
