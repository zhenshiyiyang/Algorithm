package 快手;

import java.util.Scanner;

public class second {
    private static class DataNode{
        DataNode left;
        DataNode right;
        String val;
        int sum;
        DataNode(String val) {
            this.val = val;
        }
    }
    private static String[] pre;
    private static String[] in;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] array = str.split("\\s");
        int n = array.length;
        pre = new String[n];
        for(int i = 0; i < n; i++){
            pre[i] = array[i];
        }

        str = sc.nextLine();
        array = str.split("\\s");
        in = new String[n];
        for(int i = 0; i < n; i++){
            in[i] = array[i];
        }
        DataNode root = post(0, n - 1, 0, n - 1);
        sum(root);
        print(root);
    }

    static DataNode post(int startP, int endP, int startI, int endI){

        if(startP > endP || startI > endI) return null;


        DataNode node = new DataNode(pre[startP]);
        int i = 0;
        for (int j = i + startI; j <= endI; j ++, i++) {
            if (in[j].equals(pre[startP])) break;
        }
        node.left = post(startP + 1, startP + i, startI, startI + i - 1);
        node.right = post(startP +i + 1, endP, startI + i + 1, endI);
        return node;

    }
    static int sum(DataNode root){
        if(root == null) return 0;
        root.sum = sum(root.left) + sum(root.right);
        return Integer.parseInt(root.val) + root.sum;
    }
    static void print(DataNode root){
        if(root == null) return;
        print(root.left);
        System.out.print(root.sum+" ");
        print(root.right);
    }
}
