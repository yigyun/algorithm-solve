import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int m;
    static int k;
    static int result;

    static int[][] board;
    static List<Sticker> stickers;
    // sticker
    static class Sticker{
        int size;
        List<int[]>[] list;

        Sticker(){
            this.size = 0;
            list = new List[4];
            for(int i = 0; i < 4; i++){
                list[i] = new ArrayList<>();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        stickers = new ArrayList<>();

        // 스티커 입력
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int ns = Integer.parseInt(st.nextToken());
            int ms = Integer.parseInt(st.nextToken());
            Sticker stc = new Sticker();
            int size = 0;
            for(int j = 0; j < ns; j++){
                st = new StringTokenizer(br.readLine());
                for(int l = 0; l < ms; l++){
                    int num = Integer.parseInt(st.nextToken());
                    if(num == 1){
                        size++;
                        stc.list[0].add(new int[]{j, l});
                    }
                }
            }
            stc.size = size;
            // 나머지 방향 넣어주기
            for(int j = 1; j <= 3; j++){
                for(int[] cur : stc.list[j-1]){
                    int nx = cur[1];
                    int ny = ns - 1 - cur[0];
                    stc.list[j].add(new int[]{nx, ny});
                }
                int temp = ns;
                ns = ms;
                ms = temp;
            }
            stickers.add(stc);
        }

        result = 0;
        stick();
        System.out.print(result);
    }

    static void stick(){
        for(int i = 0; i < k; i++){
            Sticker sticker = stickers.get(i);
            boolean check = true;
            S1: for(int d = 0; d < 4; d++){
                for(int x = 0; x < n; x++){
                    for(int y = 0; y < m; y++) {
                        // 이 스티커가 붙을 수 있나
                        check = true;
                        for (int[] node : sticker.list[d]) {
                            int nx = node[0] + x;
                            int ny = node[1] + y;
                            if (!isRange(nx, ny) || board[nx][ny] != 0) {
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            for (int[] node : sticker.list[d]) {
                                board[node[0] + x][node[1] + y] = 1;
                            }
                            result += sticker.size;
                            break S1;
                        }
                    }
                }
            }
        }
    }

    static boolean isRange(int nx, int ny) {
        return !(nx < 0 || nx >= n || ny < 0 || ny >= m);
    }
}