import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private ArrayList<String> vertexList;
    private int [][]edges;
    private int numsOfEdges;
    private int [] isVisisted;

    public Graph(int n){
        edges=new int[n][n];
        vertexList=new ArrayList<String>();
        numsOfEdges=0;
        isVisisted=new int[n];
    }

    public int getNumsOfEdges(){
        return numsOfEdges;
    }

    public int getNumsOfVertex(){
        return vertexList.size();
    }

    public String getValueByIndex(int index){
        return vertexList.get(index);
    }

    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    public void showGraph(){
        for (int []link:edges){
            System.out.println(Arrays.toString(link));
        }
    }

    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     *
     * @param v1 第一个节点的下标
     * @param v2 第二个节点的下标
     * @param weight 权重
     */
    public void addEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numsOfEdges++;
    }

    public void bfs(){
        LinkedList temp=new LinkedList();
        for (int i=0;i<getNumsOfVertex();i++){
            if (isVisisted[i]==0){
                temp.addLast(i);
            }
            while (temp.size()!=0){
                int cur=(Integer)temp.removeFirst();
                if (isVisisted[cur]==0){
                    isVisisted[cur]=1;
                    System.out.print("->"+vertexList.get(cur));
                    for (int j=0;j<getNumsOfVertex();j++){
                        if (isVisisted[j]==0 && edges[cur][j]==1){
                            temp.addLast(j);
                        }
                    }
                }
            }
        }
        for (int i=0;i<getNumsOfVertex();i++){
            isVisisted[i]=0;
        }
    }



    public void dfs(){
        for (int i=0;i<getNumsOfVertex();i++){
            if (isVisisted[i]==0){
                dfs(i);
            }
        }
        System.out.println();
        for (int i=0;i<getNumsOfVertex();i++){
            isVisisted[i]=0;
        }
    }

    public void dfs(int index){
        isVisisted[index]=1;
        System.out.print("->"+vertexList.get(index));
        for (int i=0;i<getNumsOfVertex();i++){
            if (isVisisted[i]==0 && edges[index][i]==1){
                dfs(i);
            }
        }
    }
}
