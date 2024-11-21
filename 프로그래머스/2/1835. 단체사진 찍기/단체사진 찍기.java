import java.util.*;
// 일렬로 나란히, 
class Solution {
    
    static int answer;
    static char[] people;
    
    public int solution(int n, String[] data) {
        answer = 0;
        people = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        
        boolean[] visited = new boolean[8];
        
        dfs(0, visited, "", data);
        
        return answer;
    }
    
    static boolean isPossible(String st, String[] data){
        for(String con : data){
            char ch1 = con.charAt(0);
            char ch2 = con.charAt(2);
            char op = con.charAt(3);
            int diff = con.charAt(4) - '0';
            
            int p1 = st.indexOf(ch1);
            int p2 = st.indexOf(ch2);

            // 둘 사이의 간격이 몇 칸 이내이냐
            int dis = Math.abs(p1 - p2) - 1;
            if(op == '='){
                if(dis != diff) return false;
            }else if(op == '<'){
                if(dis >= diff) return false;
            }else if(op == '>'){
                if(dis <= diff) return false;
            }
        }
        
        return true;
    }
    
    static void dfs(int depth, boolean[] visited, String str, String[] data){
        if(depth == 8){
            // 여기서 검증하기
            if(isPossible(str, data)){
                answer++;
            }
            return;
        }
        
        for(int i = 0; i < 8; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(depth + 1, visited, str + people[i], data);
            visited[i] = false;
        }
    }
}