package leetcode.hashmap.easy;

public class IsomorphicStrings {
    static class Solution {
        public boolean isIsomorphic(String s, String t) {

            int[] alpha = new int[200];
            int[] alpha2 = new int[200];
            if(s.length()!=t.length())
                return false;
            for(int i = 0; i < s.length(); i++){
                if(alpha[s.charAt(i)]!=alpha2[t.charAt(i)])
                    return false;

                alpha[s.charAt(i)]=i+1;
                alpha2[t.charAt(i)]=i+1;
            }
            return true;
        }
    }
}
