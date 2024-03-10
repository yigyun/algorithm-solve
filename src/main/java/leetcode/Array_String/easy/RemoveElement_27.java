package leetcode.Array_String.easy;


import java.util.Arrays;

/**
 * 정렬 문제, 유사한 리트 코드 문제 26, 203, 283
 */
class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {

        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val) count++;
            else{
                nums[i] = 100;
            }
        }

        Arrays.sort(nums);

        return count;
    }
}