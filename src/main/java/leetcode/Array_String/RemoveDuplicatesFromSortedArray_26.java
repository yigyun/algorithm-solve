package leetcode.Array_String;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  투 포인터로 더 쉽게 가능한 문제인데 메모리도 더 쓰고 시간도 더쓰는 방식임 Set은
 */

class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        Set<Integer> duplic = new HashSet<>();

        for(int num : nums) duplic.add(num);
        int size = duplic.size();
        Integer[] temp = duplic.toArray(new Integer[size]);

        for(int i = 0; i < nums.length; i++){
            if(i < size) nums[i] = temp[i];
            else nums[i] = 1001;
        }
        Arrays.sort(nums);

        return duplic.size();
    }
}

// 아래는 가장 빠른 알고리즘 투 포인터 예제

//class Solution {
//    public int removeDuplicates(int[] nums) {
//        int i = 0;
//        int j = 0;
//        while(j < nums.length) {
//            if(nums[i] >= nums[j]) {
//                j++;
//            } else {
//                i++;
//                nums[i] = nums[j];
//                j++;
//            }
//        }
//        return i+1;
//    }
//}