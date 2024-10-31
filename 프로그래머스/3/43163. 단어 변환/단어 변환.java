import java.util.*;

class Solution {
    
    static class Node{
        String str;
        int count;
        Node(String str, int count){
            this.str = str;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 51;
        
        boolean[] visited = new boolean[words.length];
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(begin, 0));
        int depth = 0;
        
        while(!que.isEmpty()){
            Node cur = que.poll();
            
            if(cur.str.equals(target)){
                answer = cur.count;
                break;
            }
            
            for(int i = 0; i < words.length; i++){
                String next = words[i];
                
                if(!isConvert(next, cur.str)){
                    continue;
                }
                
                if(visited[i]) continue;
                
                visited[i] = true;
                que.offer(new Node(next, cur.count + 1));
            }
        }
        
        return answer == 51 ? 0 : answer;
    }
    
    static boolean isConvert(String str1, String str2){
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int count = 0;
        for(int i = 0; i < ch1.length; i++){
            if(ch1[i] != ch2[i]) count++;
            if(count > 1) return false;
        }
        if(count == 0) return false;
        return true;
    }
}