package leetcode.intervals.medium;

import java.util.*;

public class InsertInterval_57 {
    static class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            List<int[]> list = new ArrayList<>();
            for(int[] number : intervals){
                list.add(number);
            }
            list.add(newInterval);

            Collections.sort(list, (o1, o2) -> {
                return o1[0] - o2[0];
            });

            int index = 0;
            int front = list.get(0)[0];
            int rear = list.get(0)[1];
            int count = list.size();
            System.out.print(count);
            while(index < count){
                int[] num = list.get(index);
                int tfront = num[0];
                int trear = num[1];
                if(rear >= tfront){
                    if(tfront < front) front = tfront;
                    if(trear > rear) rear = trear;
                } else{
                    list.add(new int[]{front, rear});
                    front = tfront;
                    rear = trear;
                }
                index++;
            }
            list.add(new int[]{front, rear});

            intervals = new int[list.size() - count][2];

            for(int i = count; i < list.size(); i++){
                intervals[i - count] = list.get(i);
            }
            return intervals;
        }
    }
}
