package leetcode.hashmap.medium;

import java.util.Arrays;

public class LongestConsecutiveSequence_128 {
    static class Solution {
        public int longestConsecutive(int[] nums) {
            if(nums.length <= 1) return nums.length;
            int max = 1;
            int count = 1;
            Arrays.sort(nums);
            for(int i = 1; i < nums.length; i++){
                if(nums[i] == nums[i-1]) continue;
                if((nums[i] - nums[i-1]) == 1){
                    count++;
                    max = Math.max(count, max);
                }else{
                    count = 1;
                }
            }
            return max;
        }
    }
}
