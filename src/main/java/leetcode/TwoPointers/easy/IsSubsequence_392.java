package leetcode.TwoPointers.easy;

public class IsSubsequence_392 {
    static class Solution {
        public boolean isSubsequence(String s, String t) {

            int length = s.length();
            int index = 0;

            for(char c : t.toCharArray()){
                if(index < length){
                    char ch = s.charAt(index);
                    if(ch == c){
                        index++;
                    }
                }
            }
            return index == length ? true : false;
        }
    }
}
