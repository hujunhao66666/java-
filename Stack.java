import java.io.IOException;

public class Stack {
    public int maxSize;
    private int [] stack;
    private int top=-1;

    public Stack(int mmaxSize){
        maxSize=mmaxSize;
        stack=new int [maxSize];
    }

    public boolean isFull(){
        return top==maxSize-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void push(int a){
        if (isFull()){
            System.out.println("栈已满");
            return ;
        }
        stack[++top]=a;

    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException();
        }
        return stack[top--];
    }

    public void showStack(){
        if (isEmpty()){
            System.out.println("栈为空");
            return;
        }
        for (int j=top;j>-1;j--){
            System.out.print(stack[j]+" ");
        }
        System.out.println();
        return;
    }
}
