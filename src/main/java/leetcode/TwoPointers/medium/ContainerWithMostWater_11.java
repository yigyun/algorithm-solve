package leetcode.TwoPointers.medium;

public class ContainerWithMostWater_11 {
    static class Solution {
        public int maxArea(int[] height) {

            int start = 0;
            int rear = height.length - 1;

            int max = 0;

            while(start != rear){
                int x = rear - start;
                int y = height[start] <= height[rear] ? height[start] : height[rear];
                int amount = x * y;
                max = Math.max(amount, max);

                if(height[start] <= height[rear]){
                    start++;
                }else{
                    rear--;
                }
            }

            return max;
        }
    }
}
