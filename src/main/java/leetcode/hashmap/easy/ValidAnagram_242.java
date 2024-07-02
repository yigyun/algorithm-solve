package leetcode.hashmap.easy;

public class ValidAnagram_242 {

    static class Solution {
        public boolean isAnagram(String s, String t) {

            if(t.length() != s.length()) return false;

            for(int i = 0; i < s.length(); i++){
                t = t.replaceFirst(s.substring(i, i+1), "");
            }

            if(t.length() == 0) return true;
            return false;
        }
    }
}
