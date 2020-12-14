import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//图
public class MGraph {
    public int numOfVerx;
    public char[] data;
    public int [][] weight;
    private static final int INF=Integer.MAX_VALUE;

    public MGraph(int verx,int [][] aweight,char[]data){
        numOfVerx=verx;
        weight=new int [verx][verx];
        this.data=data;
        //createMinTree1(verx,aweight);//Prim
        createMinTree2(verx,aweight);//Kruskal
    }

    //下面是Kruskal算法生成最小树
    private void createMinTree2(int verx,int [][]aweight){
        EdgeData[] edgeDataArr;
        int edgeNum=0;

        //统计有效边的个数
        for (int i=0;i<verx;i++){
            for (int j=i+1;j<verx;j++){
                if (aweight[i][j]!=INF){
                    edgeNum+=1;
                }
            }
        }
        edgeDataArr=new EdgeData[edgeNum];
        int index=0;
        //创建边的数组，并排序
        for (int i=0;i<verx;i++){
            for (int j=i+1;j<verx;j++){
                if (aweight[i][j]!=INF){
                    edgeDataArr[index++]=new EdgeData(i,j,aweight[i][j]);
                }
            }
        }
        sortEdgeData(edgeDataArr);

        Krusal(edgeDataArr,verx);
        for (int i=0;i<verx;i++){
            for (int j=0;j<verx;j++){
                if (i!=j && weight[i][j]==0){
                    weight[i][j]=INF;
                }
            }
        }
    }

    /**
     * 编写一个类用来存放边，记录每条边的起点和终点，并编写一个排序功能
     */
    private class EdgeData {
        int start;
        int end;
        int weight;

        public EdgeData(int start,int end,int weight){
            this.start=start;
            this.end=end;
            this.weight=weight;
        }
    }

    private void sortEdgeData(EdgeData[] edgeData){
        for (int i=0;i<edgeData.length-1;i++){
            int index=i;
            for (int j=i+1;j<edgeData.length;j++){
                if (edgeData[j].weight<edgeData[index].weight){
                    index=j;
                }
            }
            EdgeData temp=edgeData[i];
            edgeData[i]=edgeData[index];
            edgeData[index]=temp;
        }
    }

    private void Krusal(EdgeData[] edgeDataArr,int verxs){
        Set already=new HashSet();
        int count=0;
        while (count<verxs-1){
            for (EdgeData temp:edgeDataArr){
                if (!(already.contains(temp.start) && already.contains(temp.end))){
                    count+=1;
                    this.weight[temp.start][temp.end]=temp.weight;
                    this.weight[temp.end][temp.start]=temp.weight;
                    already.add(temp.start);
                    already.add(temp.end);
                }
            }
        }
    }

    //下面是Prim算法生成最小树
    private  void createMinTree1(int verx,int [][]aweight){
        int [] isVisited=new int[verx];
        isVisited[0]=1;
        for (int i=0;i<verx-1;i++){
            prim(aweight,isVisited);
        }
        for (int i=0;i<verx;i++){
            for (int j=0;j<verx;j++){
                if (weight[i][j]==0){
                    weight[i][j]=10000;
                }
            }
        }
    }

    private  void prim(int [][] aweight,int [] isVisited){
        int amin=10000;//用来表示极大值
        int temp_i=0;
        int temp_j=0;
        for (int i=0;i<isVisited.length;i++){
            if (isVisited[i]==1){
                for (int j=0;j<isVisited.length;j++){
                    if (aweight[i][j]<amin && isVisited[j]==0){
                        temp_i=i;
                        temp_j=j;
                        amin=aweight[i][j];
                    }
                }
            }
        }
        this.weight[temp_i][temp_j]=amin;
        this.weight[temp_j][temp_i]=amin;
        isVisited[temp_j]=1;
    }

    public void showGraph2(){
        int ans=0;
        for (char i:data){
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i=0;i<this.numOfVerx;i++){
            for (int j=0;j<this.numOfVerx;j++){
                if (j==0){
                    System.out.print(data[i]+" ");
                }
                if (this.weight[i][j]==INF){
                    System.out.print("INF"+" ");
                }else {
                    System.out.print(weight[i][j] + " ");
                }
                if (weight[i][j]!=INF){
                    ans+=weight[i][j];
                }
            }
            System.out.println();
        }
        System.out.println("连通所有点的最短路径为："+ans/2);
    }

    public void showGraph1(){
        int ans=0;
        for (char i:data){
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i=0;i<this.numOfVerx;i++){
            for (int j=0;j<this.numOfVerx;j++){
                if (j==0){
                    System.out.print(data[i]+" ");
                }
                System.out.print(weight[i][j]+" ");
                if (weight[i][j]!=10000){
                    ans+=weight[i][j];
                }
            }
            System.out.println();
        }
        System.out.println("连通所有点的最短路径为："+ans/2);
    }
}
