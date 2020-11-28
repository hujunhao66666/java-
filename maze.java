public class maze{
    private static int m=10;//迷宫行数
    private static int n=10;//迷宫列数

    public static int[][] createMap(){
        int[][] temp=new int [m][n];
        for (int i=0;i<m;i++){
            temp[i][0]=temp[i][n-1]=1;
        }
        for (int i=0;i<n;i++){
            temp[0][i]=temp[m-1][i]=1;
        }
        Random random=new Random();
        for (int i=0;i<(m*n)/5;i++){
            int temp1=random.nextInt(m-2)+1;
            int temp2=random.nextInt(n-2)+1;
            temp[temp1][temp2]=1;
        }
        temp[1][1]=0;
        temp[m-2][n-2]=0;
        return temp;
    }

    public static void showMap(int[][]map){
        for (int[] a:map){
            for (int b:a){
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }

    public static boolean solveMap(int i,int j,int [][]map){
        if (i<0 || i>=m || j<0 || j>=n){
            return false;
        }
        if (map[m-2][n-2]==2){
            return true;
        }
        else if (map[i][j]==0){
            map[i][j]=2;
            if (solveMap(i+1,j,map) || solveMap(i,j+1,map) || solveMap(i-1,j,map) || solveMap(i,j-1,map)){
                map[i][j]=2;
                return true;
            }
            else{
                map[i][j]=3;
                return false;
            }
        }else{
            return false;
        }

    }

    public static void main(String[]args){
        System.out.println("原地图");
        int [][] map=createMap();
        showMap(map);
        System.out.println("求解后的地图");
        solveMap(1,1,map);
        showMap(map);
    }
}
