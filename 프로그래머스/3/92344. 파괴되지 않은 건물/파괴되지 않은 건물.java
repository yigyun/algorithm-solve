class Solution {
    
    static int N;
    static int M;
    
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        // 명령을 가지고 명령을 만들어야 한다.
        int[][] changes = new int[board.length + 1][board[0].length+1];
        for(int i = 0; i < skill.length; i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3] + 1;
            int c2 = skill[i][4] + 1;
            int degree = skill[i][5];
            if(type == 1) degree = -degree;
            
            changes[r1][c1] += degree;
            changes[r1][c2] -= degree;
            changes[r2][c1] -= degree;
            changes[r2][c2] += degree;
        }
        
        //
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[x].length; y++){
                int left = y > 0 ? changes[x][y-1] : 0;
                int up = x > 0 ? changes[x-1][y] : 0;
                int diag = x > 0 && y > 0 ? changes[x-1][y-1] : 0;
                
                changes[x][y] += left+up-diag;
            }
        }
        
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[x].length; y++){
                if(board[x][y] + changes[x][y] > 0) answer++;
            }
        }
        
        return answer;
    }
    
}