public class Eightqueen{
    public static int amax;
    public static int count=0;
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        System.out.println("请输入皇后个数");
        int n=in.nextInt();
        amax=n;
        int []board=new int[n];
        check(board,0);
        System.out.printf("共有%d种解法",count);

    }

    public static void print(int [] board){
        for (int i=0;i<amax;i++){
            System.out.print(board[i]+" ");
        }
        System.out.println();
    }

    public static boolean judge(int[] board,int n){
        for (int i=0;i<n;i++){
            if (board[i]==board[n] || Math.abs(n-i)==Math.abs(board[n]-board[i]))
                return false;
        }
        return true;
    }

    public static void check(int [] board,int n){
        if (n==amax){
            count++;
            print(board);
            return;
        }
        for (int i=0;i<amax;i++){
            board[n]=i;
            if (judge(board,n)){
                check(board,n+1);
            }
        }
    }
}
