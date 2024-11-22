import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIndex = 0;
        int bIndex = 0;
        int score = 0;
        
        while(aIndex < A.length && bIndex < B.length){
            if(B[bIndex] > A[aIndex]){
                score++;
                aIndex++;
            }
            bIndex++;
        }
        
        return score;
    }
}