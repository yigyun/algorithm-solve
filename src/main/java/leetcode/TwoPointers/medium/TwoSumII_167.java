package leetcode.TwoPointers.medium;

class TwoSumII_167 {
    public int[] twoSum(int[] numbers, int target) {
        int front = 0;
        int rear = numbers.length - 1;
        int number = 0;
        while(front != rear){
            number = numbers[front] + numbers[rear];
            if(number > target){
                rear--;
                continue;
            }else if(number < target){
                front++;
                continue;
            }else{
                return new int[]{front+1, rear+1};
            }
        }
        return new int[]{front+1, rear+1};
    }
}