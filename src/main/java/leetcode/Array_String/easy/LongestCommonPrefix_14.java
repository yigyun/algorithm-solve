package leetcode.Array_String.easy;

class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        String str = "";
        if(strs.length == 1) return strs[0];
        int min = 201;
        for(int i = 0; i < strs.length; i++) {
            int stlength = strs[i].length();
            min = Math.min(min, stlength);
            if(stlength == 0) return "";
        }

        for(int i = 1; i <= min; i++){
            String temp = strs[0].substring(0, i);
            for(int j = 1; j < strs.length; j++){
                if(!temp.equals(strs[j].substring(0, i))) return str;
                if(j == strs.length-1){
                    str = temp;
                }
            }
        }

        return str;
    }
}