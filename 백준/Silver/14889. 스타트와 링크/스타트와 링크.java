import java.util.*;
import java.io.*;

class Main{

    static int N;
    static int[][] status;

    static int min;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        status = new int[N][N];
        min = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 여기부터 bfs를 시작점 i부터해서 만드는거 해서 모든 경우 고려하기.

        for(int i = 0; i < N / 2; i++){
            bfs(i);
        }

        System.out.print(min);
    }

    static void bfs(int start){
        Queue<List<Integer>> que = new LinkedList<>();
        List<Integer> set = new ArrayList<>();
        set.add(start);
        que.offer(set);

        while(!que.isEmpty()){
            List<Integer> temp = que.poll();
            if(temp.size() == N/2){
                calculate(temp);
                continue;
            }
            int last = temp.get(temp.size()-1);
            for(int i = last + 1; i < N; i++){
                List<Integer> newTemp = new ArrayList<>(temp);
                newTemp.add(i);
                que.offer(newTemp);
            }
        }
    }

    static void calculate(List<Integer> startList) {
        Set<Integer> link = new HashSet<>();
        Set<Integer> start = new HashSet<>(startList);
        for (int i = 0; i < N; i++) {
            if (!start.contains(i)) {
                link.add(i);
            }
        }
        List<Integer> linkList = new ArrayList<>(link);


        int startNum = 0;
        int linkNum = 0;

        for (int i = 0; i < startList.size(); i++) {
            int s1 = startList.get(i);
            int l1 = linkList.get(i);
            for (int j = i + 1; j < startList.size(); j++) {
                int s2 = startList.get(j);
                int l2 = linkList.get(j);
                startNum += status[s1][s2] + status[s2][s1];
                linkNum += status[l1][l2] + status[l2][l1];
            }
        }

        min = Math.min(min, Math.abs(startNum - linkNum));
    }
}