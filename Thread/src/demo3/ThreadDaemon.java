package demo3;

public class ThreadDaemon {

    public static void main(String[] args) {
        You you = new You();
        God god = new God();

        Thread thread = new Thread(god);
        thread.setDaemon(true);

        thread.start();

        new Thread(you).start();
        
    }
}

class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("保佑你发财");
        }
    }
}

class You implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("活着");
        }
        System.out.println("拜拜了世界");
    }
}
