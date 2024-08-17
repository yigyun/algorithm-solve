package programmers.level2;
import java.util.*;
public class Problem7 {

// n은 우박수열 만들때 횟수.
// 우박수열 만들면서 구간별 크기 그냥 기억하면 정적분 쉬운거아닌가?

// 우박수열 만들기 부터하기.
// 우박수열 한거 좌표 구해서 값 계산해서 list에 저장하기 이때 초항은 어차피 0,k 임

    static class Solution {
        public double[] solution(int k, int[][] ranges) {
            double[] answer = new double[ranges.length];
            // list에는 a, b 구간에 대한게 담김 a-b = a에 담기는거
            List<Double> list = new ArrayList<>();
            int n = 0;
            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{n, k});

            while(k > 1){
                n++;
                if(k % 2 == 0){
                    k /= 2;
                } else {
                    k = (k * 3) + 1;
                }

                if(!que.isEmpty()){
                    int[] temp = que.poll();
                    double sum = (double)(Math.abs(k - temp[1])) / 2;
                    if(k < temp[1]) sum += (double)k;
                    else sum += (double)temp[1];
                    list.add(sum);
                    que.offer(new int[]{n, k});
                }
            }

            for(int i = 0; i < ranges.length; i++){
                int a = ranges[i][0];
                int b = n + ranges[i][1];
                if(a == 0 && b == 0){
                    // 전체
                }else if(a == b) answer[i] = 0.0;
                else if(a > b) answer[i] = -1.0;
                else{
                    double result = 0;
                    for(int j = a; j < b; j++){
                        result += list.get(j);
                    }
                    answer[i] = result;
                }
            }

            return answer;
        }
    }
}
