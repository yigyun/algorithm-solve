import java.util.*;

class Solution {
    
    static int answer;
    static Set<Integer> result;
    static boolean[] primeSet;
    
    public int solution(String numbers) {
        answer = 0;
        result = new HashSet<>();
        primeSet = new boolean[100000000];
        
        sieveOfEratosthenes();
        
        int[] nums = new int[10];
        for(int i = 0; i < numbers.length(); i++){
            nums[numbers.charAt(i) - '0']++;
        }
        
        
        for(int i = 1; i <= numbers.length(); i++){
            dfs(nums, "", 0, i);
        }
        
                
        return result.size();
    }
    
    static void sieveOfEratosthenes() {
        primeSet[0] = true; 
        primeSet[1] = true;
        for (int i = 2; i < Math.sqrt(10000000) + 1; i++) {
            if (!primeSet[i]) {
                for (int j = i * i; j < 10000000; j += i) {
                    primeSet[j] = true;
                }
            }
        }
    }
    
    static void dfs(int[] nums, String str, int depth, int end){
        if(depth == end){
            if(!str.isEmpty()){
                int n = Integer.parseInt(str);
                if(!primeSet[n]){
                    result.add(n);
                }
            }
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(depth == 0 && i == 0) continue;
            if(nums[i] > 0){
                nums[i]--;
                dfs(nums, str + i, depth+1, end);
                nums[i]++;
            }
        }
    }

}