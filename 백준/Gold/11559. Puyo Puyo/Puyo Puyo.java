import java.util.*;
import java.io.*;

/**
 어차피 무조건 아래로 이동하기
 1. 터트리기
 2. 내리기
 * 터지지 않았으면 마무리하기

 **/

class Main{

    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        char[][] array = new char[12][6];
        int result = 0;

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 12; i++){
            String str = sc.next();
            for(int j = 0; j < 6; j++){
                array[i][j] = str.charAt(j);
            }
        }

        boolean bomb = true;
        while(bomb){
            bomb = bom(array);
            move(array);
            if(bomb){
                result++;
            }
        }

        System.out.print(result);
    }

    static void move(char[][] map){
        for(int i = 11; i >= 0; i--){
            for(int j = 0; j < 6; j++){
                if(map[i][j] != '.'){
                    int x = i;
                    char ch = map[i][j];
                    while(true){
                        int nx = x + 1;
                        if(isRange(nx, j) && map[nx][j] == '.'){
                            map[x][j] = '.';
                            map[nx][j] = ch;
                            x++;
                        }else{
                            break;
                        }
                    }
                }
            }
        }
    }

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    static boolean bom(char[][] map){
        visited = new boolean[12][6];
        boolean check = false;
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 6; j++){
                if(map[i][j] != '.' && !visited[i][j]){
                    Queue<int[]> que = new LinkedList<>();
                    char ch = map[i][j];
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i, j});
                    que.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while(!que.isEmpty()){
                        int[] current = que.poll();
                        for(int dir = 0; dir < 4; dir++){
                            int nx = current[0] + dx[dir];
                            int ny = current[1] + dy[dir];
                            if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == ch){
                                visited[nx][ny] = true;
                                que.offer(new int[]{nx, ny});
                                list.add(new int[]{nx, ny});
                            }
                        }
                    }

                    if(list.size() >= 4){
                        check = true;
                        for(int[] node : list){
                            map[node[0]][node[1]] = '.';
                        }
                    }
                }
            }
        }
        return check;
    }

    static boolean isRange(int nx, int ny){
        return !(nx < 0 || nx >= 12 || ny < 0 || ny >= 6);
    }
}