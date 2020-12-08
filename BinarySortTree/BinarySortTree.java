public class BinarySortTree {
    public Node root;

    public BinarySortTree(){
        root=null;
    }

    public void addNode(int [] arr){
        for (int a:arr){
            if (this.root==null){
                this.root=new Node(a);
                continue;
            }
            root.addNode(new Node(a));
        }

    }

    public void list(){
        if (this.root==null){
            System.out.println("该二叉树为空");
            return;
        }
        root.list();
    }

    public Node searchParent(int a){
        if (root==null){
            return null;
        }

        Node ans=this.root.nodeSearchParent(a);
        //System.out.println(ans);
        return ans;
    }

    public Node searchNode(int a){
        return root.nodeSearchNode(a);
    }

    public void deleteNode(int a){
        if (root==null){
            return ;
        }


        if (root.value==a){//删除根结点
            if (root.left==null && root.right==null){
                root=null;
                return;
            }else {
                if (root.left==null){
                    root=root.right;
                    return;
                }else if (root.right==null){
                    root=root.left;
                    return;
                }else{
                    Node tempLeft=root.left;
                    root=root.right;
                    Node temp=root;
                    while (temp.left!=null){
                        temp=temp.left;
                    }
                    temp.left=tempLeft;
                    return;
                }
            }

        }else{
            Node parent=null;
            Node cur=searchNode(a);
            if (cur==null){
                System.out.println("要删除的结点不存在");
                return ;
            }
            parent=searchParent(a);

            //删除叶子节点
            if (cur.left==null && cur.right==null){
                if (parent.left==cur){
                    parent.left=null;
                }else{
                    parent.right=null;
                }
                return ;
            }

            //删除只有一个子节点的结点
            if ((cur.right==null && cur.left!=null) || (cur.left==null && cur.right!=null)){
                if (parent.right==cur){
                    if (cur.right==null){
                        parent.right=cur.left;
                    }else{
                        parent.right=cur.right;
                    }
                }else{
                    if (cur.right==null){
                        parent.left=cur.left;
                    }else{
                        parent.left=cur.right;
                    }
                }
                return ;
            }

            //删除两个节点的结点
            Node tempLeft=cur.left;
            if (parent.right==cur){
                parent.right=cur.right;
                Node temp1=cur.right;
                while (temp1.left!=null){
                    temp1=temp1.left;
                }
                temp1.left=tempLeft;
            }else{
                parent.left=cur.right;
                Node temp1=cur.right;
                while (temp1.left!=null){
                    temp1=temp1.left;
                }
                temp1.left=tempLeft;
            }
            return ;

        }
    }
}
