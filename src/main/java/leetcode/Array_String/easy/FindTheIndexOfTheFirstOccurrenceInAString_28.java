package leetcode.Array_String.easy;

class FindTheIndexOfTheFirstOccurrenceInAString_28 {
    public int strStr(String haystack, String needle) {
        int length = needle.length();
        char ch = needle.substring(0,1).charAt(0);
        if(haystack.equals(needle)) return 0;
        for(int i = 0; i < haystack.length(); i++){
            if(i+length > haystack.length()) break;
            if(haystack.charAt(i) == ch){
                if(haystack.substring(i, i+length).equals(needle))
                    return i;
            }
        }
        return -1;
    }
}