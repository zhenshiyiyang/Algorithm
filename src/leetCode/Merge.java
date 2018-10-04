package leetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Merge {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public static void main(String[] args) {

    }
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();
        if(intervals == null || intervals.size()<1){
            return result;
        }
        // 先对区间进行排序，使用一个匿名内部类
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        //遍历所有元素
        Interval pre = null;
        for(Interval i:intervals){
            //如果前面元素的末尾小于后边元素的开始，这是正常的情况
            if(pre==null || pre.end<i.start){
                result.add(i);
                pre = i;
            }else if(pre.end<i.end){
                //如果不是正常的情况并且后边末尾元素比前边的末尾元素大
                pre.end = i.end;
            }
        }
        return result;
    }
}
