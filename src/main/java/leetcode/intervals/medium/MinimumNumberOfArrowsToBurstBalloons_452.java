package leetcode.intervals.medium;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons_452 {

    static class Solution {
        public int findMinArrowShots(int[][] points) {
            int count = 1;
            int index = 0;
            Arrays.sort(points, (o1, o2) -> {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            });
            int del = points[0][1];

            while(index < points.length){
                if(points[index][0] <= del && points[index][1] >= del){
                    index++;
                    continue;
                }else{
                    del = points[index][1];
                    count++;
                }
            }

            return count;
        }
    }
}
