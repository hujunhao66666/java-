public class Node {
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value=value;
    }
    @Override
    public String toString(){
        return "value="+this.value;
    }

    public void addNode(Node a){
        if (a.value>=this.value){
            if (this.right==null){
                this.right=a;
                return;
            }else{
                this.right.addNode(a);
            }
        }else{
            if (this.left==null){
                this.left=a;
                return;
            }else{
                this.left.addNode(a);
            }
        }
    }

    public void list(){
        if (this.left!=null){
            this.left.list();
        }
        System.out.println(this.value+" ");
        if (this.right!=null){
            this.right.list();
        }
    }

    public Node nodeSearchParent(int a){

        if (this.left!=null && this.left.value==a){
            return this;
        }
        if (this.right!=null && this.right.value==a){
            return this;
        }

        if (a>this.value){
            if (this.right!=null){
                return this.right.nodeSearchParent(a);
            }
            else{
                return null;
            }
        }

        else if (a<this.value){
            if (this.left!=null){
                return this.left.nodeSearchParent(a);
            }
            else{
                return null;
            }
        }
        return null;
    }

    public Node nodeSearchNode(int a){
        if (this.value==a){
            return this;
        }
        if (a>this.value){
            if (this.right!=null){
                return this.right.nodeSearchNode(a);
            }else{
                return null;
            }
        }else{
            if (this.left!=null){
                return this.left.nodeSearchNode(a);
            }
            else{
                return null;
            }
        }
    }
}
