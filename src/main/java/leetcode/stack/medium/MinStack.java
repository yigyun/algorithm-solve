package leetcode.stack.medium;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

        int peek;
        List<Integer> stack;

        public MinStack() {
            this.stack = new ArrayList<>();
            this.peek = 0;
        }

        public void push(int val) {
            this.peek++;
            stack.add(val);
        }

        public void pop() {
            stack.remove(this.peek - 1);
            this.peek--;
        }

        public int top() {
            return stack.get(peek - 1);
        }

        public int getMin() {
            int min = Integer.MAX_VALUE;
            for(int number : this.stack){
                min = Math.min(min, number);
            }
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
