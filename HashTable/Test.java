import javafx.scene.SnapshotParameters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Test{
    public static void menu(){
        System.out.println("1.添加雇员");
        System.out.println("2.显示所有雇员");
        System.out.println("3.查找雇员");
        System.out.println("4.删除雇员");
        System.out.println("5.退出");
    }
    public static void main(String[]args){
        HashTable hashTable=new HashTable(10);
        while (true){
            menu();
            Scanner in=new Scanner(System.in);
            int choice=in.nextInt();
            switch (choice){
                case 1:
                    System.out.println("输入雇员id");
                    int id=in.nextInt();
                    System.out.println("输入雇员姓名");
                    in.nextLine();
                    String name=in.nextLine();
                    hashTable.add((new Emp(id,name)));
                    break;
                case 2:
                    hashTable.list();
                    break;
                case 3:
                    System.out.println("输入要查找的雇员id");
                    int id1=in.nextInt();
                    hashTable.find(id1);
                    break;
                case 4:
                    System.out.println("输入要删除的雇员id");
                    int id2=in.nextInt();
                    hashTable.delete(id2);
                    break;
                case 5:
                    return ;
                default:
                    System.out.println("请重新输入");
                    break;
            }
        }

    }
}
