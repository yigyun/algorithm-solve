package leetcode.Array_String.medium;

class JumpGame_55 {
    public boolean canJump(int[] nums) {

        boolean[] possible = new boolean[nums.length];
        possible[nums.length-1] = true;
        int step = 1;
        for(int i = nums.length-1; i > 0; i--){
            if(possible[i]){
                if(nums[i-1] != 0) possible[i-1] = true;
                else{
                    step++;
                }
            }else{
                if(nums[i-1] - step < 0) step++;
                else{
                    step = 1;
                    possible[i-1] = true;
                }
            }
        }
        return possible[0];
    }
}