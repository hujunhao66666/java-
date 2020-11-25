public class Circle {
    private LinkNode first;
    public Circle(){
        first=new LinkNode(-1);
    }
    public LinkNode getFirst(){
        return first;
    }

    public void addNode(LinkNode a){
        if (first.id==-1){
            first=a;
            first.next=first;
            return;

        }
        LinkNode temp=first;
        while (temp.next!=first){
            temp=temp.next;
        }
        temp.next=a;
        a.next=first;
        return;
    }

    public void deleteNode(int iid){
        LinkNode temp=first;
        while (temp.next!=first && temp.next.id!=iid){
            temp=temp.next;
        }
        if (temp.next==first){
            if (first.id==iid){
                if (first.next==first){
                    first=new LinkNode(-1);
                    return;
                }
                first=first.next;
                temp.next=first;
                return;
            }
            else {
                System.out.println("没找到该节点");
                return;
            }
        }

        temp.next=temp.next.next;
        return;
    }

    public void showList(){
        if (first.id==-1){
            System.out.println("链表为空");
            return;
        }

        LinkNode temp=first;
        while (temp.next!=first){
            System.out.println(temp.id);
            temp=temp.next;
        }
        System.out.println(temp.id);
        return;
    }
}
