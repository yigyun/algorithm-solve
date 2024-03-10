package leetcode.Array_String.easy;

import java.util.Arrays;

class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        int max = 0;
        int result = 0;
        Arrays.sort(nums);

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(i < nums.length - 1 && nums[i] == nums[i+1]) {
                count++;
            } else {
                if(count >= max){
                    result = nums[i];
                    max = count;
                }
                count = 0;
            }
        }

        if(count > max){
            result = nums[nums.length - 1];
        }

        return result;
    }
}