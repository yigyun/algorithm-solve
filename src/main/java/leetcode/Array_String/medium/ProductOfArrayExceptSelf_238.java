package leetcode.Array_String.medium;

class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        int max = 1;
        boolean check = false;
        int count = 0;

        for(int number : nums){
            if(number != 0) max *= number;
            if(number == 0 && !check) {
                check = true;
                count++;
            } else if(check && number == 0) max = 0;
        }

        if(count == nums.length) return answer;

        for(int i = 0; i < answer.length; i++){
            if(check){
                if(nums[i] == 0){
                    answer[i] = max;
                }
            }else{
                answer[i] = max / nums[i];
            }
        }

        return answer;
    }
}
