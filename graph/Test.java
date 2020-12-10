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
        int n=8;
        Graph graph=new Graph(n);
        String vertexValue[]={"1","2","3","4","5","6","7","8"};
        for (String a:vertexValue){
            graph.insertVertex(a);
        }
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        //graph.addEdge(1,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,1);
        graph.addEdge(3,7,1);
        graph.addEdge(4,7,1);
        graph.addEdge(2,5,1);
        graph.addEdge(2,6,1);
        graph.addEdge(5,6,1);
        graph.dfs();
        //graph.showGraph();
        graph.bfs();
    }
}
