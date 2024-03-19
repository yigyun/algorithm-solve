package leetcode.Array_String.medium;

class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split(" ");
        s = "";
        for(int i = str.length-1; i >= 0; i--){
            if(!str[i].equals("")){
                if(i != 0){
                    s += str[i];
                    s += " ";
                }else{
                    s += str[i];
                }
            }
        }
        return s;
    }
}