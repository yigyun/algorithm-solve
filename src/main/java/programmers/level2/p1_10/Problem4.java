package programmers.level2;

public class Problem4 {
    // 같은행, 같은열, 대각선에 있으면 공격이 가능함.
// 이 세가지 경우에 해당하면 불가능하게 return 하면 됨.


    static class Solution {

        static boolean[][] matrix;
        static boolean[] col;
        // 대각선 용도
        static boolean[] diag1;
        static boolean[] diag2;
        static int result;

        public int solution(int n) {
            int answer = 0;

            result = 0;
            col = new boolean[n];
            diag1 = new boolean[2 * n - 1];
            diag2 = new boolean[2 * n - 1];

            dfs(0, n);

            return result;
        }

        private void dfs(int row, int n){
            if(row == n){
                result++;
                return;
            }

            for(int c = 0; c < n; c++){
                if(col[c] || diag1[row + c] || diag2[row - c + n - 1]){
                    continue;
                }
                col[c] = true; diag1[row + c] = true; diag2[row - c + n - 1] = true;
                dfs(row + 1, n);
                col[c] = false; diag1[row + c] = false; diag2[row - c + n - 1] = false;
            }
        }

    }
}
