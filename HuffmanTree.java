/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public Node root;
    public HuffmanTree(int []arr){
        List<Node> nodes=new ArrayList<Node>();
        for (int i=0;i<arr.length;i++){
            nodes.add(new Node(arr[i]));
        }
        Collections.sort(nodes);
        //System.out.println(nodes);
        while (nodes.size()!=1){
            Node a=nodes.get(0);
            Node b=nodes.get(1);
            Node parent=new Node(a.value+b.value);
            parent.left=a;
            parent.right=b;
            nodes.remove(a);
            nodes.remove(b);
            nodes.add(parent);
            Collections.sort(nodes);
        }
        //System.out.println(nodes);
        root=nodes.get(0);
    }



}
*/
