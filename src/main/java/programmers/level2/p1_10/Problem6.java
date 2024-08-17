package programmers.level2;
import java.util.*;
public class Problem6 {

   static class Solution {
        public int solution(int[] picks, String[] minerals) {
            int answer = 0;
            // 일단 다이아 개수, 그 다음이 철 개수, 그 다음이 돌
            List<int[]> piro = new ArrayList<>();
            for(int i = 0; i < minerals.length; i+= 5){
                int range = i + 5;
                if(range >= minerals.length){
                    range = minerals.length;
                }
                int[] mi = new int[3];
                for(int j = i; j < range; j++){
                    if(minerals[j].equals("diamond")) mi[0]++;
                    else if(minerals[j].equals("iron")) mi[1]++;
                    else mi[2]++;
                }
                piro.add(mi);
            }

            int gok = 0;
            for(int i = 0; i < 3; i++) gok += picks[i];

            while(gok < piro.size()){
                piro.remove(piro.size()-1);
            }

            Collections.sort(piro, (o1, o2) -> {
                if(o1[0] == o2[0]){
                    if(o1[1] == o2[1])
                        return o2[2] - o1[2];
                    else return o2[1] - o1[1];
                } else return o2[0] - o1[0];
            });

            for(int i = 0; i < piro.size(); i++){
                int[] mi = piro.get(i);
                if(picks[0] != 0){
                    picks[0]--;
                    answer += mi[0] + mi[1] + mi[2];
                } else if(picks[1] != 0){
                    picks[1]--;
                    answer += (mi[0] * 5) + mi[1] + mi[2];
                } else if(picks[2] != 0){
                    picks[2]--;
                    answer += (mi[0] * 25) + (mi[1] * 5) + mi[2];
                }
            }


            return answer;
        }
    }
}
