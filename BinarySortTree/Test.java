import javafx.scene.SnapshotParameters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Test{
    public static void main(String[]args){
        int [] arr={7,3,10,12,5,1,9};
        BinarySortTree tree=new BinarySortTree();
        tree.addNode(arr);
        tree.list();
        System.out.println("开始删除节点了");
        tree.deleteNode(1);
        tree.deleteNode(5);
        tree.deleteNode(3);
        tree.deleteNode(7);
        tree.deleteNode(9);
        tree.deleteNode(12);
        tree.deleteNode(10);
        tree.list();
    }
}
