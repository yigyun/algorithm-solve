import java.util.*;
import java.io.*;

/**
 N x N
 r,c 시작이 1,1
 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리
 두 점 사이의 거리는 맨해튼 거리
 도시의 치킨 거리 = 모든 집의 치킨 거리 합

 필요한 거

 **/

class Main{

    static int N;
    static int M;

    static int[][] map;

    static List<int[]> chickens;
    static List<int[]> homes;
    static int result;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        chickens = new ArrayList<>();
        homes = new ArrayList<>();
        result = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) chickens.add(new int[]{i, j});
                else if(map[i][j] == 1) homes.add(new int[]{i, j});
            }
        }

        // cheickens에서 m개를 선택하는거임.
        dfs(0, 0,  new ArrayList<int[]>());
        
        System.out.print(result);
    }

    static void findDistance(List<int[]> list){
        
        int distance = 0;
        
        for(int[] home : homes){
            int x = home[0];
            int y = home[1];
            int min = 2501;
            for(int[] node : list){
                min = Math.min(min, distance(x, y, node[0], node[1]));
            }
            distance += min;
        }
        
        result = Math.min(distance, result);
    }

    static void dfs(int index, int depth, List<int[]> list){
        if(depth == M){
            // 거리 찾기
            findDistance(list);
            return;
        }

        for(int i = index; i < chickens.size(); i++){
            list.add(chickens.get(i));
            dfs(i + 1, depth + 1, list);
            list.remove(list.size() - 1);
        }
    }

    static boolean isRange(int nx, int ny){
        return !(nx < 0 || ny < 0 || nx >= N || ny >= N);
    }

    static int distance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}