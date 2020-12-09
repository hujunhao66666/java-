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
        //int [] arr={4,3,6,5,7,8};
        //int [] arr={10,12,8,7,9,6};
        int []arr={10,11,7,6,8,9};
        AVLtree tree=new AVLtree();
        tree.addNode(arr);
        //tree.list();
        //tree.rightRotate();
        //tree.list();
        //System.out.println(tree.root.getHeight());
        System.out.println(tree.RightHeight());
        System.out.println(tree.LeftHeight());
    }
}
