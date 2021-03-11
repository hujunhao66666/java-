package demo2;

public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany=new WeddingCompany(new You());
        weddingCompany.Marry();
    }

}

class WeddingCompany implements Marry{
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void Marry() {
        before();
        System.out.println("帮助布置婚礼");
        this.target.Marry();
        after();
    }

    private void after() {
        System.out.println("结婚后");
    }

    private void before() {
        System.out.println("结婚前");
    }
}


class You implements Marry{

    @Override
    public void Marry() {
        System.out.println("你结婚了");
    }
}

interface Marry{
    void Marry();
}
