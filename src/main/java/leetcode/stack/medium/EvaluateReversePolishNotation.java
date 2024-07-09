package leetcode.stack.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<String> cal = new Stack<>();

            for(String str : tokens){
                if(str.equals("+")){
                    int number1 = Integer.parseInt(cal.pop());
                    int number2 = Integer.parseInt(cal.pop());
                    int sum = number1 + number2;
                    cal.push(String.valueOf(sum));
                } else if(str.equals("-")){
                    int number1 = Integer.parseInt(cal.pop());
                    int number2 = Integer.parseInt(cal.pop());
                    int sum = number2 - number1;
                    cal.push(String.valueOf(sum));
                } else if(str.equals("*")){
                    int number1 = Integer.parseInt(cal.pop());
                    int number2 = Integer.parseInt(cal.pop());
                    int sum = number1 * number2;
                    cal.push(String.valueOf(sum));
                } else if(str.equals("/")){
                    int number1 = Integer.parseInt(cal.pop());
                    int number2 = Integer.parseInt(cal.pop());
                    int sum = number2 / number1;
                    cal.push(String.valueOf(sum));
                } else cal.push(str);
            }
            return Integer.parseInt(cal.pop());
        }
    }
}
