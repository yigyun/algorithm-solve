import java.util.*;

class Solution {
    
    static class Stock{
        int t;
        int p;
        Stock(int t, int p){
            this.p = p;
            this.t = t;
        }
    }
    
    public int[] solution(int[] prices) {
        
        Stack<Stock> stack = new Stack<>();
        int n = prices.length;
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++){
            if(stack.isEmpty()) stack.push(new Stock(i, prices[i]));
            else{
                while(!stack.isEmpty() && stack.peek().p > prices[i]){
                    Stock st = stack.pop();
                    answer[st.t] = i - st.t;
                }
                stack.push(new Stock(i, prices[i]));
            }
        }
        
        n = n-1;
        while(!stack.isEmpty()){
            Stock st = stack.pop();
            answer[st.t] = n - st.t;
        }
        
        return answer;
    }
}