package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Combine {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n,k));
    }
    public static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (k > n) {
            return ret;
        }
        List<Integer> list = new ArrayList<Integer>();
        getpass(n, k, list, ret, 1);
        return ret;
    }
    public static void getpass(int n, int k, List<Integer> list, List<List<Integer>> ret, int start) {
        if (list.size() == k) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            System.out.println(list);
            getpass(n, k, list, ret, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
