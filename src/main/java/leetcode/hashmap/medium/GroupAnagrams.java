package leetcode.hashmap.medium;


import java.util.*;

public class GroupAnagrams {

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();

            Map<String, List<String>> map = new HashMap<>();

            for(int i = 0; i < strs.length; i++){
                if(strs[i].equals("U")) continue;
                char[] temp = strs[i].toCharArray();
                Arrays.sort(temp);

                if(!map.containsKey(String.valueOf(temp))){
                    List<String> list = new ArrayList<>();
                    list.add(strs[i]);
                    map.put(String.valueOf(temp), list);
                } else{
                    List<String> list = map.get(String.valueOf(temp));
                    list.add(strs[i]);
                    map.put(String.valueOf(temp), list);
                }
            }

            for(List<String> list : map.values()){
                result.add(list);
            }

            return result;
        }
    }
}
