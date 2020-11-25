public class LinkStack {
    private Node head;
    private Node top;

    public LinkStack(){
        head=new Node(-1);
        top=head;
    }

    public void push(int a){
        Node b=new Node(a);
        top.next=b;
        top=b;
    }

    public boolean isEmpty(){
        return top==head;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException();
        }
        int a=top.id;
        Node temp=head;
        while (temp.next!=top){
            temp=temp.next;
        }

        top=temp;
        temp.next=null;
        return a;
    }

    public void showStack(){
        if (isEmpty()){
            System.out.println("链表为空");
            return;
        }
        Node temp=head.next;
        while (temp!=null){
            System.out.print(temp.id+" ");
            temp=temp.next;
        }
        System.out.println();
        return ;
    }

}
