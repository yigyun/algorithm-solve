import java.util.*;

// 1번 각 장르의 총합을 저장하는 곳
// 2번 각 장르에서 재생된 노래 순서대로 정렬하는 곳 + 3번 까지 고려하는 곳
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, PriorityQueue<int[]>> reply = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < plays.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            if(!reply.containsKey(genres[i])){
                PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> {
                    if(o1[0] == o2[0]){
                        return o1[1] - o2[1];
                    }
                    return o2[0] - o1[0];
                });
                que.offer(new int[]{plays[i], i});
                reply.put(genres[i], que);
            }else{
                reply.get(genres[i]).offer(new int[]{plays[i], i});
            }
        }
        
        PriorityQueue<String[]> que = new PriorityQueue<>((o1, o2) -> {
            int num1 = Integer.parseInt(o1[1]);
            int num2 = Integer.parseInt(o2[1]);
            return num2 - num1;
        });
        for(String key : map.keySet()){
            que.offer(new String[]{key, Integer.toString(map.get(key))});
        }
        
        while(!que.isEmpty()){
            String[] cur = que.poll();
            String key = cur[0];
            int count = 2;
            PriorityQueue<int[]> find = reply.get(key);
            while(!find.isEmpty() && count > 0){
                count--;
                int[] node = find.poll();
                result.add(node[1]);
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}