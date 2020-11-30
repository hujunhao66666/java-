
public class Search{
    public static int find(int[]a,int target){
        for (int i=0;i<a.length;i++){
            if (a[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static int binaryFind(int []a,int target,int left,int right){
        if (left>right){
            return -1;
        }
        int mid=(left+right)/2;
        if (a[mid]==target){
            return mid;
        }else if(a[mid]>target){
            return binaryFind(a,target,mid+1,right);
        }
        else{
            return binaryFind(a,target,left,mid-1);
        }
    }
    public static ArrayList<Integer> binaryFind2(int []a,int target,int left,int right){
        if (left>right){
            return new ArrayList<Integer>();
        }
        int mid=(left+right)/2;
        ArrayList<Integer> arr=new ArrayList<Integer>();
        if (a[mid]==target){
            arr.add(mid);
            int temp=mid-1;
            while (temp>0 && a[temp]==target){
                arr.add(temp);
                temp-=1;
            }
            temp=mid+1;
            while (temp<a.length && a[temp]==target){
                arr.add(temp);
                temp+=1;

            }
            arr.sort(Comparator.naturalOrder());
            return arr;
        }else if (a[mid]>target){
            return binaryFind2(a,target,left,mid-1);
        }else{
            return binaryFind2(a,target,mid+1,right);
        }
    }
    public static int insertValueFind(int[]a,int left,int right,int target){
        if (left>right || target<a[0] || target>a[a.length-1]){
            return -1;
        }
        int mid=left+(right-left)*(target-a[left])/(a[right]-a[left]);
        if (a[mid]==target){
            return mid;
        }else if(a[mid]>target){
            return binaryFind(a,target,mid+1,right);
        }
        else{
            return binaryFind(a,target,left,mid-1);
        }
    }
    public static int[] fib(){
        int maxSize=20;
        int []f=new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i=2;i<maxSize;i++){
            f[i]=f[i-2]+f[i-1];
        }
        return f;
    }
    public static int fibFind(int []a,int key){
        int low=0;
        int high=a.length-1;
        int k=0;
        int mid=0;
        int f[]=fib();
        while (high>f[k]-1){
            k++;
        }
        int []temp=Arrays.copyOf(a,f[k]);
        for (int i=high+1;i<temp.length;i++){
            temp[i]=a[high];
        }
        while (low<=high){
            mid=low+f[k-1]-1;
            if (key<temp[mid]){
                high=mid-1;
                k--;
            }
            else if (key>temp[mid]){
                low=mid+1;
                k-=2;

            }
            else {
                if (mid<=high){
                    return mid;
                }else{
                    return high;
                }
            }
        }
        return -1;
    }
    public static void main(String[]args){
        int []a={5,2,8,1,0};
        System.out.println(find(a,2));
        System.out.println(find(a,10));
        int []b={1,2,3,4,5,6,7};
        System.out.println(binaryFind(b,4,0,6));
        System.out.println(binaryFind(b,10,0,6));
        int []c={1,2,3,4,6,6,6,7,8,9,10};
        System.out.println(binaryFind2(c,6,0,c.length-1));
        System.out.println(binaryFind2(c,11,0,c.length-1));
        System.out.println(insertValueFind(b,0,b.length-1,4));
        System.out.println(insertValueFind(b,0,b.length-1,8));
        System.out.println(fibFind(b,5));
        System.out.println(fibFind(b,8));
    }
}
