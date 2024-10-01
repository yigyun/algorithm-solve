import java.util.*;
import java.io.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        // 자카드 유사도
        // 모두 공집합이면 1로 정의
        // 65536을 곱하고 소수점 아래를 버리고 정수부만 출력
        if(str1.length() == 0 && str2.length() == 0) return 1;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < str1.length()-1; i++){
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i+1);
            if(Character.isAlphabetic(ch1) && Character.isAlphabetic(ch2)){
                map1.put(str1.substring(i, i+2).toLowerCase(), map1.getOrDefault(str1.substring(i, i+2).toLowerCase(), 0) + 1);
            }
        }
        
        for(int i = 0; i < str2.length()-1; i++){
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i+1);
            if(Character.isAlphabetic(ch1) && Character.isAlphabetic(ch2)){
                map2.put(str2.substring(i, i+2).toLowerCase(), map2.getOrDefault(str2.substring(i, i+2).toLowerCase(), 0) + 1);
            }
        }
        
        if(map1.size() == 0 && map2.size() == 0) return 65536;
        
        Map<String, Integer> intersection = new HashMap<>();
        for(String key1 : map1.keySet()){
            for(String key2 : map2.keySet()){
                if(key1.equals(key2)){
                    // 교집합 추가
                    int number = map1.get(key1) <= map2.get(key2) ? map1.get(key1) : map2.get(key2);
                    intersection.put(key1, number);
                }
            }
        }
        
        Map<String, Integer> union = new HashMap<>(map1);
        map2.forEach((key, value) -> union.merge(key, value, Integer::sum));
        
        
        int num1 = 0;
        int num2 = 0;
        
        for(String key : union.keySet()){
            if(intersection.containsKey(key)){
                num1 += intersection.get(key);
                num2 += (union.get(key) - (intersection.get(key)));
            }else{
                num2 += union.get(key);
            }
        }
        
        if(num1 == num2) return 65536;
        
        answer = 65536 * num1 / num2;
        
        
        return answer;
    }
}