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

public class KMPandBetterKMP{
    public static void main(String[]args){
        String str1="BBC ABCDAB ABCDABCDABDE";
        String str2="ABCDABD";
        System.out.println(betterKMP(str1,str2));
    }

    /**
     * 改进后的KMP算法
     * @param originText
     * @param useText
     * @return
     */
    public static int betterKMP(String originText,String useText){
        int i=0,j=0;
        int[]nextVal=getNextVal(useText);
        while (i<originText.length() && j<useText.length()){
            if (j==-1 || originText.charAt(i)==useText.charAt(j)){
                i++;
                j++;
            }else{
                j=nextVal[j];
            }
        }
        if (j>=useText.length()){
            return i-useText.length();
        }
        return -1;
    }

    public static int[] getNextVal(String useText){
        int [] nextVal=new int [useText.length()];
        int j=0,k=-1;
        nextVal[0]=-1;
        while (j<useText.length()-1){
            if (k==-1 || useText.charAt(j)==useText.charAt(k)){
                j++;
                k++;
                if (useText.charAt(j)!=useText.charAt(k)){
                    nextVal[j]=k;
                }else{
                    nextVal[j]=nextVal[k];
                }
            }else{
                k=nextVal[k];
            }
        }
        return nextVal;
    }

    /**
     *
     * @param originText 要被匹配的字符串
     * @param useText   用来匹配的字符串
     * @return 从左到右，第一个匹配成功的下标
     */
    public static int KMP(String originText,String useText){
        int[] next=getNext(useText);
        int i=0;
        int j=0;
        while (i<originText.length() && j<useText.length()){
            if (j==-1 || originText.charAt(i)==useText.charAt(j)){
                j++;
                i++;
            }else{
                j=next[j];
            }
        }
        if (j>=useText.length()){
            return i-useText.length();
        }
        return -1;
    }

    public static int[] getNext(String useText){
        int j=0,k=-1;
        int [] next=new int [useText.length()];
        next[0]=-1;
        while (j<useText.length()-1){
            if(k==-1 || useText.charAt(j)==useText.charAt(k)){
                k++;
                j++;
                next[j]=k;
            }else{
                k=next[k];
            }
        }
        return next;
    }
}
