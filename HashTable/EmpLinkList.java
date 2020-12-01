public class EmpLinkList {
    private Emp head;
    public void find(int id){
        if (isEmpty()){
            System.out.println("没有找到");
            return;
        }
        Emp temp=head;
        while (temp!=null && temp.id!=id){
            temp=temp.next;
        }
        if (temp==null){
            System.out.println("没有找到此id");
            return ;
        }
        temp.print();
        return ;
    }
    public void delete(int id){
        if (isEmpty()){
            System.out.println("链表为空");
            return;
        }
        if (head.id==id){
            head=head.next;
            System.out.println("删除成功");
            return;
        }
        Emp temp=head;
        while (temp.next!=null && temp.next.id!=id){
            temp=temp.next;
        }
        if (temp.next==null){
            System.out.println("没有你要删除的id");
            return;
        }
        temp.next=temp.next.next;
        System.out.println("删除成功");
        return;
    }

    public void add(Emp p){
        if (head==null){
            head=p;
        }
        else{
            Emp temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=p;
        }
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void list(){
        if (head==null){
            System.out.println("链表为空");
            return;
        }
        Emp temp=head;
        while (temp!=null) {
            temp.print();
            temp = temp.next;
        }
        return;
    }


}
