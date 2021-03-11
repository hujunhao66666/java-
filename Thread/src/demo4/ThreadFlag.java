package demo4;

public class ThreadFlag {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();

    }
}

class Player extends Thread{
    TV tv;

    public Player(TV tv){
        this.tv=tv;
    }

    @Override
    public void run() {
        for (int i=0;i<20;i++){
            if (i%2==0){
                this.tv.play("两只老虎");
            }else{
                this.tv.play("爱跳舞");
            }
        }
    }
}

class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv=tv;
    }

    @Override
    public void run() {
        for (int i=0;i<20;i++){
            tv.watch();
        }
    }
}

class TV{
    String name;
    boolean flag=true;

    public synchronized void play(String name){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("正在表演"+name);
        this.notifyAll();
        this.name=name;
        this.flag=!this.flag;


    }

    public synchronized void watch(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("正在看"+name);
        this.notifyAll();
        this.flag=!this.flag;



    }
}