package leetcode.slidingwindow;

public class MinimumSizeSubarraySum_209 {

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {

            int i = 0;
            int j = 0;
            // 최소 길이를 찾음
            int mn = Integer.MAX_VALUE;
            int sum = 0;
            while(j < nums.length){
                sum += nums[j];
                while(sum >= target){
                    mn = Math.min(mn, j-i+1);
                    sum -= nums[i++];
                }
                j++;
            }
            return mn == Integer.MAX_VALUE ? 0 : mn;
        }
    }

}
