import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class infixCompute{
    public static boolean isChar(char a){
        return a=='+' || a=='-' || a=='*' || a=='/';
    }

    public static int priority(char a){
        if (a=='*' || a=='/')return 1;
        return 0;
    }

    public static int compute(int a,int b,char c){
        switch (c){
            case '+':
                return a+b;
            case '-':
                return b-a;
            case '*':
                return a*b;
            case '/':
                return b/a;
            default:
                throw new RuntimeException("现在还不能计算这些");
        }
    }

    public static void main(String[]args)  {
        SymbolStack symbolStack=new SymbolStack(10);
        Stack stack=new Stack(10);
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int temp=0;
        for (int i=0;i<s.length();i++){

            if (isChar(s.charAt(i))){
                stack.push(temp);
                temp=0;
                if (symbolStack.isEmpty()){
                    symbolStack.push(s.charAt(i));
                }
                else if (priority(s.charAt(i))<=priority(symbolStack.peek())){
                    stack.push(compute(stack.pop(),stack.pop(),symbolStack.pop()));
                    symbolStack.push(s.charAt(i));
                }
                else{
                    symbolStack.push(s.charAt(i));
                }

            }
            else{
                //stack.push(s.charAt(i)-48);
                temp=temp*10+(s.charAt(i)-48);
            }
        }
        stack.push(temp);
        while (!symbolStack.isEmpty()){
            stack.push(compute(stack.pop(),stack.pop(),symbolStack.pop()));
        }
        System.out.println(stack.pop());
    }
}
