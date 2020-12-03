public class BinaryTree {
    private heroNode root;

    public  void setRoot(heroNode a){
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
            heroNode temp=root.preOrderSearch(target);
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
            heroNode temp=root.infixOrderSearch(target);
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
            heroNode temp=root.postOrderSearch(target);
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
