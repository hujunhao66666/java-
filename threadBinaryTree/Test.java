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
    public static void main(String[]args) {
        HeroNode a=new HeroNode(1,"tom");
        HeroNode a1=new HeroNode(2,"Jima");
        HeroNode a2=new HeroNode(3,"Jack");
        HeroNode a3=new HeroNode(4,"Bery");
        HeroNode a4=new HeroNode(5,"Peter");
        HeroNode a5=new HeroNode(6,"HUju");
        HeroNode a6=new HeroNode(7,"Wuyong");
        a.setRight(a2);
        a.setLeft(a1);
        a1.setRight(a4);
        a1.setLeft(a3);
        a2.setRight(a6);

        ThreadedBinaryTree tree=new ThreadedBinaryTree();
        tree.setRoot(a);
        tree.threadBinaryTree();
        HeroNode temp=a4.getLeft();
        HeroNode temp1=a4.getRight();
        /*System.out.println("5号结点的前驱结点是"+temp.getId());
        System.out.println("5号结点的后继结点是"+temp1.getId());*/
        tree.list();
    }
}
