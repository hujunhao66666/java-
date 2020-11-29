public class Sort{
    public static int[] BubbleSort(int[] b){
        int [] a=b.clone();
        for (int i=0;i<a.length-1;i++){
            int flag=0;
            for (int j=0;j<a.length-i-1;j++){
                if (a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    flag=1;
                }
            }
            if (flag==0){
                break;
            }
        }
        return a;
    }

    public static int[] SelectSort(int []a){
        int[]b=a.clone();
        for (int i=0;i<b.length;i++){
            int amin=b[i];
            int index=i;
            for (int j=i+1;j<b.length;j++){
                if (b[j]<amin){
                    amin=b[j];
                    index=j;
                }
            }
            b[index]=b[i];
            b[i]=amin;
        }
        return b;
    }
    public static int[] InsertSort(int[]a){
        int [] b=a.clone();

        for (int i=1;i<a.length;i++){
            int temp=i-1;
            int val=b[i];
            while (temp>=0 && b[temp]>val){
                b[temp+1]=b[temp];
                temp--;
            }
            b[temp+1]=val;

        }
        return b;
    }
    public static int[] ShellSort(int []a){
        int []b=a.clone();
        for (int gap=b.length;gap>0;gap/=2){
            /*for (int i=gap;i<b.length;i++){
                if (b[i]<b[i-gap]){
                    int temp=b[i-gap];
                    b[i-gap]=b[i];
                    b[i]=temp;
                }
            }*/  //插入法
            for (int i=gap;i<b.length;i++){
                if (b[i]<b[i-gap]){
                    int temp=b[i];
                    int j=i;
                    while (j>0 && temp<a[j-gap]){
                        b[j]=b[j-gap];
                        j-=gap;
                    }
                    b[j]=temp;
                }
            }//移动法
        }
        return b;
    }

    public static void quickSort(int[] arr,int left,int right){
        int l=left;
        int r=right;
        int midNum=arr[(l+r)/2];
        while (l<r){
            while (arr[l]<midNum){
                l+=1;
            }
            while (arr[r]>midNum){
                r-=1;
            }
            if (l>=r)break;
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

        }
        if (l==r){
            l-=1;
            r+=1;
        }
        if (l>left){
            quickSort(arr,left,l);
        }
        if (r<right){
            quickSort(arr,r,right);
        }
        return ;
    }
    public static void mergeSort(int []a,int left,int right,int []temp){
        if (left>=right)return;
        int mid=(left+right)/2;
        mergeSort(a,left,mid,temp);
        mergeSort(a,mid+1,right,temp);
        merge(a,left,mid,right,temp);
    }

    public static void merge(int []arr,int left,int mid,int right,int []temp){
        int i=left;
        int j=mid+1;
        int t=0;
        while (i<=mid && j<=right){
            if (arr[i]<=arr[j]){
                temp[t++]=arr[i++];
            }
            else{
                temp[t++]=arr[j++];
            }
        }

        while (i<=mid){
            temp[t++]=arr[i++];
        }

        while (j<=right){
            temp[t++]=arr[j++];
        }

        int index=left;
        int ia=0;
        while (index<=right){
            arr[index++]=temp[ia++];
        }
    }

    public static void radixSort(int []a){
        int amax=a[0];
        for (int i=1;i<a.length;i++){
            if (a[i]>amax){
                amax=a[i];
            }
        }
        int alen=(amax+"").length();
        int [][] bucket=new int[10][a.length];
        int [] count=new int[10];

        for (int j=0,n=1;j<alen;j++,n*=10){
            for (int i=0;i<a.length;i++){
                int num=a[i]/n%10;
                bucket[num][count[num]]=a[i];
                count[num]++;
            }

            int index=0;
            for (int i=0;i<10;i++){
                if (count[i]!=0){
                    for (int k=0;k<count[i];k++){
                        a[index++]=bucket[i][k];
                    }
                }
                count[i]=0;
            }
        }

    }
    public static void print(int [] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[]args){
        int[] arr={3,9,-1,20,10};
        print(arr);
        print(BubbleSort(arr));
        print(SelectSort(arr));
        print(InsertSort(arr));
        print(ShellSort(arr));
        int []brr=arr.clone();
        quickSort(brr,0,brr.length-1);
        print(brr);
        int []temp=new int[arr.length];
        int []crr=arr.clone();
        mergeSort(crr,0,crr.length-1,temp);
        print(crr);
        int []drr={4,934,16,9,1245,2};
        print(drr);
        radixSort(drr);
        print(drr);
    }
}
