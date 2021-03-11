package demo4;

public class ThreadPC extends Thread {
    public static void main(String[] args) {
        Container container = new Container();

        Consumer consumer = new Consumer(container);
        Productor productor = new Productor(container);

        consumer.start();
        productor.start();
    }
}

class Chicken{
    private int id;

    public Chicken( int i) {
        this.id=i;
    }
}

class Container{
    Chicken [] container=new Chicken[10];
    int count=0;

    public synchronized void push(Chicken chicken){
        if (count==container.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        container[count]=chicken;
        count++;
        this.notifyAll();

    }

    public synchronized Chicken pop() throws InterruptedException {
        if (count==0){
            this.wait();
        }


        count--;
        Chicken chicken = container[count];

        this.notifyAll();
        return chicken;
    }

}

class Consumer extends Thread{
    Container container;

    public Consumer(Container container){
        this.container=container;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("消费了"+i+"只鸡");
            try {
                container.pop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor extends Thread{
    Container container;

    public Productor(Container container){
        this.container=container;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("生产了"+i+"只鸡");
            container.push(new Chicken(i));
        }
    }
}