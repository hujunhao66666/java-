public class ThreadedBinaryTree {
    private HeroNode root;
    private HeroNode pre;

    public void list(){
        if (root==null){
            System.out.println("树为空");
            return ;
        }
        HeroNode temp=root;
        while (temp.getLeftType()==0){
            temp=temp.getLeft();
        }
        while (temp.getRight()!=null || temp.getRightType()==1){
            System.out.println(temp);
            temp=temp.getRight();
        }
        System.out.println(temp);
    }

    public void threadBinaryTree(){
        threadBinaryTree(root);
    }

    public void threadBinaryTree(HeroNode node){
        if (node==null){
            return;
        }
        threadBinaryTree(node.getLeft());
        if (node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;
        threadBinaryTree(node.getRight());
    }


    public  void setRoot(HeroNode a){
        root=a;
    }

    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }
        else{
            System.out.println("树为空");
        }
    }

    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }
        else{
            System.out.println("树为空");
        }
    }

    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }
        else{
            System.out.println("树为空");
        }
    }

    public void preOrderSearch(int target){
        if (this.root==null){
            System.out.println("该树为空");
        }
        else{
            HeroNode temp=root.preOrderSearch(target);
            if (temp==null){
                System.out.println("没找到");
            }
            else {
                System.out.println("找到了" + temp);
            }
        }
    }

    public void infixOrderSearch(int target){
        if (this.root==null){
            System.out.println("该树为空");
        }
        else{
            HeroNode temp=root.infixOrderSearch(target);
            if (temp==null){
                System.out.println("没找到");
            }
            else {
                System.out.println("找到了" + temp);
            }
        }
    }

    public void postOrderSearch(int target){
        if (this.root==null){
            System.out.println("该树为空");
        }
        else{
            HeroNode temp=root.postOrderSearch(target);
            if (temp==null){
                System.out.println("没找到");
            }
            else {
                System.out.println("找到了" + temp);
            }
        }
    }

    public void deleteNode(int target){

        if (this.root==null){
            System.out.println("树为空");
            return ;
        }
        if (this.root.getId()==target){
            this.root=null;
            return;
        }
        this.root.deleteNode(target);
    }
}