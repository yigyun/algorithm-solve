import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        Set<Character> set = new HashSet<>();
        for(char ch : my_string.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                answer += ch;
            }
        }
        return answer;
    }
}