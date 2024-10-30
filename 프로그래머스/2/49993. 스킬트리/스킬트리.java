import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Set<Character> set = new HashSet<>();
        for(char ch : skill.toCharArray()){
            set.add(ch);
        }
        
        for(int i = 0; i < skill_trees.length; i++){
            String str = "";
            for(char ch : skill_trees[i].toCharArray()){
                if(set.contains(ch)) str += ch;
            }
            
            if(str.length() != 0){
                char[] chrs = str.toCharArray();
                boolean check = true;
                for(int j = 0; j < chrs.length; j++){
                    if(skill.charAt(j) != chrs[j]){ check = false; break;}
                }
                if(check) answer++;
            }else answer++;
        }
        
        return answer;
    }
}