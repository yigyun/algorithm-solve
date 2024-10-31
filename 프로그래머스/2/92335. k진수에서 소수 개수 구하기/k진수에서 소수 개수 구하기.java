import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        int count = 0;
        String[] strs = Integer.toString(n, k).split("0");
        Set<Long> set = new HashSet<>();
        
        for(String str : strs){
            if(str.length() == 0) continue;
            long num = Long.parseLong(str);
            
            if(set.contains(num)) count++;
            else{
                if(isPrime(num)){
                    set.add(num);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    static boolean isPrime(long num){
        for(long i = 2; i <= Math.sqrt(num); i++){
            if(num % i != 0) continue;
            else return false;
        }
        if(num == 1) return false;
        return true;
    }
}