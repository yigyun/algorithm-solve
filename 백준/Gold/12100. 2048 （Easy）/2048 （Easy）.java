import java.util.*;
import java.io.*;

public class Main{

    static int max = 0;
    static int N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(board, 0);

        System.out.print(max);
    }

    static void dfs(int[][] board, int count) {
        if (count == 5) {
            int curMax = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    curMax = Math.max(board[i][j], curMax);
                }
            }
            max = Math.max(max, curMax);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[][] nextBoard = new int[N][N];
            for (int a = 0; a < N; a++) {
                nextBoard[a] = board[a].clone(); // 배열 복사 최적화
            }
            move(nextBoard, i);
            dfs(nextBoard, count + 1);
        }
    }
    static void move(int[][] board, int dir){
    switch (dir) {
        case 0: // 오른쪽
            for (int i = 0; i < N; i++) {
                int[] temp = new int[N];
                int position = N - 1;
                for (int j = N - 1; j >= 0; j--) {
                    if (board[i][j] != 0) {
                        if (temp[position] == 0) {
                            temp[position] = board[i][j];
                        } else if (temp[position] == board[i][j]) {
                            temp[position] *= 2;
                            position--;
                        } else {
                            position--;
                            temp[position] = board[i][j];
                        }
                    }
                }
                board[i] = temp;
            }
            break;
        case 1: // 왼쪽
            for (int i = 0; i < N; i++) {
                int[] temp = new int[N];
                int position = 0;
                for (int j = 0; j < N; j++) {
                    if (board[i][j] != 0) {
                        if (temp[position] == 0) {
                            temp[position] = board[i][j];
                        } else if (temp[position] == board[i][j]) {
                            temp[position] *= 2;
                            position++;
                        } else {
                            position++;
                            temp[position] = board[i][j];
                        }
                    }
                }
                board[i] = temp;
            }
            break;
        case 2: // 아래
            for (int j = 0; j < N; j++) {
                int[] temp = new int[N];
                int position = N - 1;
                for (int i = N - 1; i >= 0; i--) {
                    if (board[i][j] != 0) {
                        if (temp[position] == 0) {
                            temp[position] = board[i][j];
                        } else if (temp[position] == board[i][j]) {
                            temp[position] *= 2;
                            position--;
                        } else {
                            position--;
                            temp[position] = board[i][j];
                        }
                    }
                }
                for (int i = 0; i < N; i++) {
                    board[i][j] = temp[i];
                }
            }
            break;
        case 3: // 위
            for (int j = 0; j < N; j++) {
                int[] temp = new int[N];
                int position = 0;
                for (int i = 0; i < N; i++) {
                    if (board[i][j] != 0) {
                        if (temp[position] == 0) {
                            temp[position] = board[i][j];
                        } else if (temp[position] == board[i][j]) {
                            temp[position] *= 2;
                            position++;
                        } else {
                            position++;
                            temp[position] = board[i][j];
                        }
                    }
                }
                for (int i = 0; i < N; i++) {
                    board[i][j] = temp[i];
                }
            }
            break;
        }
    }
}