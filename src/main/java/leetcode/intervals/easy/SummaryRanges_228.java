package leetcode.intervals.easy;

import java.util.*;

public class SummaryRanges_228 {
    static class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> result = new ArrayList<>();
            if(nums.length == 0) return result;
            if(nums.length == 1){ result.add(String.valueOf(nums[0])); return result; }

            int count = 0;
            int current = nums[0];
            for(int i = 1; i < nums.length; i++){
                if(nums[i] != (current+1)){
                    if(count == 0)
                        result.add(String.valueOf(current));
                    else
                        result.add(String.valueOf(current - count) + "->" + String.valueOf(current));

                    count = 0;
                    current = nums[i];
                }else{
                    count++;
                    current++;
                }
            }

            if(count == 0)
                result.add(String.valueOf(current));
            else
                result.add(String.valueOf(current - count) + "->" + String.valueOf(current));

            return result;
        }
    }

}
