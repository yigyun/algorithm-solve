package leetcode.Array_String.easy;

class LengthOfLastWorld_58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        for(int i = s.length(); i >= 0; i--){
            if(i == 0 && !s.substring(i, i+1).equals(" ")) return s.length();
            if(s.substring(i-1, i).equals(" ")) return s.length() - i;
        }
        return 0;
    }
}
