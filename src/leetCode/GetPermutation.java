package leetCode;

import java.util.*;
/*
  思路解析：
  先把1到n的每个数存入list中，然后后边写一个数字，就可以从里面删掉一个了。
  n个数字有n!个排列方式，n-1就有(n-1)！个排列方式，
  为了和下标保持一致，需要k--，k/（n-1）！是当前字符的下标（注意是从零开始啊，下标0对应的数字1）
  下一次的k就可以更新为 k%(n-1)!，循环n次
  需要一个times表示每次更新阶乘的除数。
 */
public class GetPermutation {
    public static void main(String[] args) {
          int n = 4;
          int k = 9;
          System.out.println(getPermutation(n,k));
    }
    public static String getPermutation(int n, int k) {
        k--;
        List<Integer> list = new ArrayList<Integer>();//注意存储1-n
        StringBuilder s = new StringBuilder();
        int times = n-1;
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int factorail = 1;//阶乘
        for(int i=2;i<n;i++){//不要×n
            factorail*=i;
        }
        while(times>=0){
            int indexList = k/factorail;
            s.append(list.get(indexList));
            list.remove(indexList);
            k=k%factorail;
            if(times!=0){
                factorail/=times;
            }
            times--;
        }
        return s.toString();
    }
}
