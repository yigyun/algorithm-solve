class Solution {
    
    static int[][] map = new int[][]{
        {3, 1},
        {0, 0}, {0, 1}, {0, 2},
        {1, 0}, {1, 1}, {1, 2},
        {2, 0}, {2, 1}, {2, 2},
    };
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[] right = new int[]{3, 2}; 
        int[] left = new int[]{3, 0};
        
        for(int i = 0; i < numbers.length; i++){
            int number = numbers[i];
            if(number == 1 || number == 4 || number == 7){
                // 왼손
                left = map[number];
                answer += "L";
            }else if(number == 3 || number == 6 || number == 9){
                // 오른손
                right = map[number];
                answer += "R";
            }else{
                // 거리 보고 같으면 손
                int[] point = map[number];
                int ldis = distance(point, left);
                int rdis = distance(point, right);
                if(ldis == rdis){
                    if(hand.equals("left")){
                        left = point;
                        answer += "L";
                    }else{
                        right = point;
                        answer += "R";
                    }
                }else if(ldis < rdis){
                    left = point;
                    answer += "L";
                }else{
                    right = point;
                    answer += "R";
                }
            }
        }
        
        return answer;
    }
    
    static int distance(int[] point1, int[] point2){
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}