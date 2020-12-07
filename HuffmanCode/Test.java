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
        /*String content="i like like java very much";
        System.out.println(content);
        byte [] bytes=content.getBytes();
        byte[] newBytes=HuffmanCode.zip(bytes);
        byte[] by=HuffmanCode.unzip(newBytes);
        System.out.println(by);*/
        String srcFile="E://HJH/1.txt";
        String dstFile="E://HJH/2.zip";
        String dstFile1="E://HJH/3.txt";
        //HuffmanCode.zipFile(srcFile,dstFile);
        HuffmanCode.unzipFile(dstFile,dstFile1);
    }
}
