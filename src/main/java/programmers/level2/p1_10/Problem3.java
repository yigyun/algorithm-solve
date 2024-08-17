package programmers.level2;

public class Problem3 {
    static class Solution {
        public int solution(String[] board) {
            int answer = -1;
            // 선공 후공이 정해짐 즉 X가 O보다 많을 수 없음.
            // 여러 개의 종결 조건이 있다면, 잘못된 거임.
            char[][] ch = new char[board.length][];
            // O와 X의 개수
            int o = 0;
            int x = 0;
            for(int i = 0; i < 3; i++){
                ch[i] = board[i].toCharArray();
                for(int j = 0; j < 3; j++){
                    if(ch[i][j] == 'O') o++;
                    else if(ch[i][j] == 'X') x++;
                }
            }

            if(x > o) return 0;
            if(o > (x+1)) return 0;

            int xw = 0;
            int ow = 0;
            int count = 0;
            for(int i = 0; i < 3; i++){
                if(ch[i][0] != '.' && ch[i][0] == ch[i][1] && ch[i][1] == ch[i][2]){
                    if(ch[i][0] == 'O') ow++;
                    else xw++;
                    count++;
                }
                if(ch[0][i] != '.' && ch[0][i] == ch[1][i] && ch[1][i] == ch[2][i]){
                    if(ch[0][i] == 'O') ow++;
                    else xw++;
                    count++;
                }
            }
            if(ch[1][1] != '.' && ch[1][1] == ch[0][2] && ch[1][1] == ch[2][0]){
                if(ch[1][1] == 'O') ow++;
                else xw++;
                count++;
            }
            if(ch[1][1] != '.' && ch[1][1] == ch[0][0] && ch[1][1] == ch[2][2]){
                if(ch[1][1] == 'O') ow++;
                else xw++;
                count++;
            }


            if(ow == 1 && xw == 1) return 0;
            else if(ow != 0){
                if(o != x + 1) return 0;
            } else if(xw != 0) {
                if(x != o) return 0;
            }



            return 1;
        }
    }
}
