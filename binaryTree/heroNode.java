public class heroNode {
    private int id;
    private String name;
    private heroNode left;
    private heroNode right;
    public heroNode(int iid,String nname){
        id=iid;
        name=nname;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setLeft(heroNode a){
        left=a;
    }

    public void setRight(heroNode b){
        right=b;
    }

    @Override
    public String toString(){
        return "HeroNode [no="+id+", name="+name+"]";
    }
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
    public void postOrder(){
        if (this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    public heroNode preOrderSearch(int target){
        if (this.id==target){
            return this;
        }
        heroNode res=null;
        if (this.left!=null){
            res=this.left.preOrderSearch(target);
        }
        if (res!=null){
            return res;
        }
        if (this.right!=null){
            res=this.right.preOrderSearch(target);
        }
        return res;
    }

    public heroNode infixOrderSearch(int target){
        heroNode res=null;
        if (this.left!=null){
            res=this.left.preOrderSearch(target);
        }
        if (res!=null){
            return res;
        }
        if (this.id==target){
            return this;
        }
        if (this.right!=null){
            res=this.right.preOrderSearch(target);
        }
        return res;
    }

    public heroNode postOrderSearch(int target){
        heroNode res=null;
        if (this.right!=null){
            res=this.left.preOrderSearch(target);
        }
        if (res!=null){
            return res;
        }

        if (this.right!=null){
            res=this.right.preOrderSearch(target);
        }
        if (res!=null){
            return res;
        }
        if (this.id==target){
            return this;
        }
        return res;
    }

    public void deleteNode(int target){
        if (this.left!=null && this.left.id==target){
            this.left=null;
            return;
        }
        if (this.right!=null && this.right.id==target){
            this.right=null;
            return;
        }
        if (this.left!=null) {
            this.left.deleteNode(target);
        }
        if (this.right!=null){
            this.right.deleteNode(target);
        }
        return ;
    }
}
