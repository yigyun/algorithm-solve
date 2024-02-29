package leetcode.Array_String;

import java.util.Arrays;

/**
 * 투 포인터 문제
 */

class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m; i < m+n; i++){
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
        System.out.print(nums1);
    }
}
