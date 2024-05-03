package leetcode.hashmap.easy;

public class RansomNote_383 {
    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            for(int i = 0; i < magazine.length(); i++){
                String str = magazine.substring(i, i+1);
                ransomNote = ransomNote.replaceFirst(str, "");
            }
            if(ransomNote.length() > 0) return false;
            return true;
        }
    }
}
