import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class HuffmanCode {
    private static Map<Byte,String>map=new HashMap<Byte,String>();

    public static byte[] zip(byte[] bytes){
        List<Node> nodes=getNodes(bytes);
        Node root=createHuffmanTree(nodes);
        //root.list();
        getCodes(root);
        /*System.out.println(map);*/

        StringBuilder stringBuilder1=new StringBuilder();
        for (byte b:bytes){
            stringBuilder1.append(map.get(b));
        }

        int index=0;
        int len;
        if (stringBuilder1.length()%8==0){
            len=stringBuilder1.length()/8;
        }else{
            len=stringBuilder1.length()/8+1;
        }
        byte [] by=new byte[len];
        for (int i=0;i<stringBuilder1.length();i+=8){
            String str;
            if (i+8>stringBuilder1.length()){
                str=stringBuilder1.substring(i);
            }else{
                str=stringBuilder1.substring(i,i+8);
            }
            by[index]=(byte)Integer.parseInt(str,2);
            index++;
        }
        return by;
    }

    private static List<Node> getNodes(byte[]bytes){
        ArrayList<Node> nodes=new ArrayList<Node>();
        Map<Byte,Integer> map=new HashMap<>();
        Integer count;
        for (byte b:bytes){
            count=map.get(b);
            if (count==null){
                map.put(b,1);
            }else{
                map.put(b,count+1);
            }
        }
        for (Map.Entry<Byte,Integer> entry:map.entrySet()){
            nodes.add(new  Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1) {
            Collections.sort(nodes);
            Node a=nodes.get(0);
            Node b=nodes.get(1);
            Node c=new Node(null,a.weight+b.weight);
            c.left=a;
            c.right=b;
            nodes.remove(a);
            nodes.remove(b);
            nodes.add(c);
        }
        return nodes.get(0);
    }

    private static Map<Byte,String> getCodes(Node node){
        if (node==null){
            return null;
        }
        StringBuilder a=new StringBuilder();
        Map<Byte,String> amap=new HashMap<>();
        getCodes(node.left,"0",a);
        getCodes(node.right,"1",a);
        return amap;
    }

    private static void getCodes(Node node,String s,StringBuilder stringBuilder){
        StringBuilder stringBuilder1=new StringBuilder(stringBuilder);
        stringBuilder1.append(s);
        if (node!=null) {
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder1);
                getCodes(node.right, "1", stringBuilder1);
            } else {
                map.put(node.data, stringBuilder1.toString());
            }
        }
    }


    private static String byteToBitString(boolean flag,byte b){
        int temp=b;
        if (flag) {

            temp |=256;
        }
        String str=Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length()-8);
        }
        return str;

    }

    public static byte[] unzip(Map<Byte,String> amap,byte[] bytes){
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<bytes.length;i++){
            byte b=bytes[i];
            boolean flag=(i==bytes.length-1);
            stringBuilder.append(byteToBitString(!flag,b));
        }
        Map<String,Byte> newMap=new HashMap<String,Byte>();
        for (Map.Entry<Byte,String> entry:amap.entrySet()){
            newMap.put(entry.getValue(),entry.getKey());
        }
        /*for (Map.Entry<String,Byte> entry:newMap.entrySet()){
            System.out.print(entry+" ");
        }*/
        //System.out.println(newMap);

        String temp="";

        List<Byte> list=new ArrayList<>();

        for (int i=0;i<stringBuilder.length();){
            int count=1;
            boolean flag=true;
            Byte b=null;
            while (flag) {
                String key = stringBuilder.substring(i, i + count);
                b = newMap.get(key);

                if (b == null) {
                    count++;
                    /*System.out.print(temp+" ");*/
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i+=count;
        }
        /*System.out.println(list);*/

        byte[] bytes1=new byte[list.size()];
        for (int i=0;i<bytes1.length;i++){
            bytes1[i]=list.get(i);
        }
        return bytes1;

    }

    public static void unzipFile(String srcFile,String dstFile){
        OutputStream os =null;
        InputStream is=null;
        ObjectInputStream ois=null;
        try {
            is = new FileInputStream(srcFile);
            ois=new ObjectInputStream(is);
            ois.readObject();

            byte [] huffmanBytes=(byte[])ois.readObject();
            Map<Byte,String> codes=(Map<Byte,String>)ois.readObject();
            byte[] bytes=unzip(codes,huffmanBytes);
            os=new FileOutputStream(dstFile);
            os.write(bytes);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try{
                is.close();
                ois.close();
                os.close();
            }catch (Exception e2){
                System.out.println(e2.getMessage());
            }
        }
    }

    public static void zipFile(String srcFile,String dstFile){
        FileInputStream is =null;
        OutputStream os=null;
        ObjectOutputStream oos=null;
        try {
            is = new FileInputStream(srcFile);
            byte [] b=new byte[is.available()];
            is.read(b);

            byte[] huffmanBytes=zip(b);
            os=new FileOutputStream(dstFile);
            oos=new ObjectOutputStream(os);
            oos.writeObject(huffmanBytes);
            oos.writeObject(map);


        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try{
                is.close();
                oos.close();
                os.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
