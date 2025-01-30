import java.util.*;
import java.io.*;

/*
    빈칸, 집, 치킨집
    N x N
    1,1에서 시작함.
    치킨 거리는 집과 가장 가까운 치킨집 사이의 거리
    도시 거리는 모든 집의 치킨 거리 합
    거리 공식: 절댓값
*/

class Main{

    static int n;
    static int m;
    static int[][] map;
    static List<int[]> home;
    static List<int[]> chs;
    static List<Integer>[] homeTochs;

    static int min;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int cc = 0;
        map = new int[n][n];
        min = Integer.MAX_VALUE;
        home = new ArrayList<>();
        chs = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    cc++;
                    home.add(new int[]{i, j});
                }else if(map[i][j] == 2){
                    chs.add(new int[]{i, j});
                }
            }
        }

        // 거리계산하기
        homeTochs = new List[cc];
        for(int i = 0; i < cc; i++){
            homeTochs[i] = new ArrayList<>();
        }

        for(int i = 0; i < home.size(); i++){
            int[] curHome = home.get(i);
            for(int j = 0; j < chs.size(); j++){
                int[] curChs = chs.get(j);
                int dis = Math.abs(curHome[0] - curChs[0]) + Math.abs(curHome[1] - curChs[1]);
                homeTochs[i].add(dis);
            }
        }

        find(0, 0, new boolean[chs.size()]);

        System.out.print(min);
    }

    static void find(int index, int count, boolean[] store){
        if(count == m){
            // 여기가 치킨집 선택한거임
            int sum = 0;
            for(List<Integer> list : homeTochs){
                int mis = Integer.MAX_VALUE;
                for(int i = 0; i < list.size(); i++){
                    if(store[i]){
                        mis = Math.min(mis,list.get(i));
                    }
                }
                sum += mis;
            }
            min = Math.min(min, sum);
            return;
        }

        for(int i = index; i < store.length; i++){
            if(store[i]) continue;
            store[i] = true;
            find(i + 1, count + 1, store);
            store[i] = false;
        }
    }
}