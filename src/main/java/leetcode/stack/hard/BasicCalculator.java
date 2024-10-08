package leetcode.stack.hard;

import java.util.Stack;

public class BasicCalculator {
    static class Solution {
        public int calculate(final String s) {
            final Stack<Integer> stack = new Stack<>();

            int sign = 1, number = 0, result = 0;

            for(int i = 0; i < s.length(); ++i) {
                final char c = s.charAt(i);

                if(Character.isDigit(c)) {
                    number = 10 * number + c - '0';
                } else if(c == '+') {
                    result += sign * number;
                    number = 0;
                    sign = 1;
                } else if(c == '-') {
                    result += sign * number;
                    number = 0;
                    sign = -1;
                } else if(c == '(') {
                    stack.push(result);
                    stack.push(sign);
                    sign = 1;
                    result = 0;
                } else if(c == ')') {
                    result += sign * number;
                    number = 0;
                    result *= stack.pop();
                    result += stack.pop();
                }
            }

            if(number != 0)
                result += sign * number;

            return result;
        }
    }
}
