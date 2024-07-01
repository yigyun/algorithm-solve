package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class softeer7 {
    static class Room{
        String name;
        List<Time> timeList;
        int size;
        Room(String name){
            this.name = name;
            timeList = new ArrayList<>();
            size = 0;
        }

        void add(Time t){
            this.timeList.add(t);
            size += 1;
        }
    }

    static class Time{
        int start;
        int end;
        Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, int[]> room = new HashMap<>();
        List<String> nameList = new ArrayList<>();

        for(int i =0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            nameList.add(name);
            room.put(name, new int[19]);
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int[] temp = room.get(name);
            if(start == end) continue;
            for(int a = start; a < end; a++){
                temp[a] = 1;
            }
            room.put(name, temp);
        }

        // 시간대의 수 만들기.
        List<Room> roomList = new ArrayList<>();

        for(String str : nameList){
            Room troom = new Room(str);
            int[] temp = room.get(str);
            int count = 0;
            temp[18] = 1;
            for(int i = 9; i < 19; i++){
                if(temp[i] == 0) count++;
                if(temp[i] == 1 && count != 0){
                    troom.add(new Time(i-count, i));
                    count = 0;
                }
            }
            roomList.add(troom);
        }

        Collections.sort(roomList, (o1, o2) -> {
            return o1.name.compareTo(o2.name);
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            Room r = roomList.get(i);
            sb.append("Room ").append(r.name).append(":").append("\n");
            if(r.size == 0) sb.append("Not ").append("available").append("\n");
            else{
                sb.append(r.size).append(" available:").append("\n");
                for(Time t : r.timeList){
                    if(t.start == 9)
                        sb.append("09");
                    else{
                        sb.append(t.start);
                    }
                    sb.append("-").append(t.end).append("\n");
                }
            }
            if(i != N-1)
                sb.append("-----").append("\n");
        }

        System.out.print(sb.toString());
    }
}
