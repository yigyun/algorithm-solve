package leetcode.Array_String.medium;

class JumpGame2_45 {
    public int jump(int[] nums) {
        int maxStep = nums[0];
        int maxPos = nums[0];
        if(nums.length < 2) return 0;
        int jumps = 1;
        for(int i = 1; i < nums.length; i++){
            if(maxStep < i){
                jumps++;
                maxStep = maxPos;
            }
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        return jumps;
    }
}