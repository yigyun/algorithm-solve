import java.util.*;

/**
    택배상자는 크기가 같고 1번 ~ n번대로 컨테이너 벨트로 전달
    알려준 순서에 맞게 영재가 택배상자를 실어야 한다.
    순서랑 다른 상자는 잠시 다른 곳에 보관한다.
    
**/

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        int index1 = 0;
        int num = 1;
        while(index1 < order.length){
            if(order[index1] == num){
                index1++;
                num++;
                answer++;
            }else if(!stack.isEmpty() && stack.peek() == order[index1]){
                index1++;
                stack.pop();
                answer++;
            }else if(num < order.length){
                stack.push(num);
                num++;
            } else break;
        }
                
        return answer;
    }
}