package leetcode.intervals.medium;

import java.util.*;

public class MergeIntervals_56 {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length == 1) return intervals;

            List<int[]> list = new ArrayList<>();

            Arrays.sort(intervals, (o1, o2) -> {return o1[0] - o2[0];});
            int front = intervals[0][0];
            int rear = intervals[0][1];

            int i = 0;
            while(++i < intervals.length){
                int tfront = intervals[i][0];
                int trear = intervals[i][1];
                if(rear >= tfront){
                    if(tfront < front) front = tfront;
                    if(rear < trear) rear = trear;
                } else{
                    list.add(new int[]{front, rear});
                    front = tfront;
                    rear = trear;
                }
            }
            list.add(new int[]{front,rear});

            int[][] result = new int[list.size()][2];

            for(i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }

            return result;
        }
    }

}
