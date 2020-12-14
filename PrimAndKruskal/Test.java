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
    public static void main(String[]args) {
        char []data={'A','B','C','D','E','F','G'};
        int verxs=data.length;
        final int INF=Integer.MAX_VALUE;
        /*int [][] weight={
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,10,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,10,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };
        MGraph mgraph=new MGraph(verxs,weight,data);
        mgraph.showGraph();*/
        int [][] weight={
                {0,5,7,INF,INF,INF,2},
                {5,INF,INF,9,INF,INF,3},
                {7,INF,INF,INF,8,INF,INF},
                {INF,9,INF,INF,INF,10,INF},
                {INF,INF,8,INF,INF,5,4},
                {INF,INF,INF,10,5,INF,6},
                {2,3,INF,INF,4,6,INF}
        };
        MGraph mGraph=new MGraph(verxs,weight,data);
        mGraph.showGraph2();
    }

}
