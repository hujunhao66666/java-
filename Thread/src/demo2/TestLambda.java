package demo2;

public class TestLambda {
    //静态内部类
    static class TempThird implements Temp{

        @Override
        public void lambda() {
            System.out.println("<-------()adbmal");
        }
    }

    public static void main(String[] args) {
        Temp I=new TempTwice();
        Temp II=new TempThird();
        I.lambda();
        II.lambda();

        //局部内部类
        class TempForth implements Temp{

            @Override
            public void lambda() {
                System.out.println("<--------->");
            }
        }

        Temp III=new TempForth();
        III.lambda();


        //匿名内部类
        Temp IIII=new Temp(){

            @Override
            public void lambda() {
                System.out.println("<><<><><><><");
            }
        };
        IIII.lambda();

        //用lambda进一步简化
        Temp IIIII=()->{
            System.out.println("<------>-----------<");
        };

        IIIII.lambda();

        Love love=null;

        love=a->{
            System.out.println(a);
        };
        love.love(521);
    }
}

interface Temp{
    void lambda();
}

class TempTwice implements Temp{

    @Override
    public void lambda() {
        System.out.println("lambda()----->");
    }
}

interface Love{
    void love(int a);
}