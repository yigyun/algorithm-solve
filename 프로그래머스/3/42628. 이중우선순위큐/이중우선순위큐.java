import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < operations.length; i++){
            String[] strs = operations[i].split(" ");
            char ch = strs[0].charAt(0);
            int num = Integer.parseInt(strs[1]);
            if(ch == 'I') list.add(num);
            else if(ch == 'D'){
                if(list.size() == 0) continue;
                if(num == 1){
                    list.remove(list.size() - 1);
                }else{
                    list.remove(0);
                }
            }
            Collections.sort(list);
        }
        if(list.size() == 0) return new int[]{0, 0};
        
        return new int[]{list.get(list.size() - 1), list.get(0)};
    }
}