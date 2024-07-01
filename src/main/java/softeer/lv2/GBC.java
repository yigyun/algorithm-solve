package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GBC {
    static class Node{
        int speed;
        int end;
        int start;
        Node(int start, int end, int speed){
            this.speed = speed;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> def = new ArrayList<>();
        int accumulatedDistance = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            def.add(new Node(accumulatedDistance, accumulatedDistance + distance, speed));
            accumulatedDistance += distance;
        }

        int maxSpeedDifference = 0;
        int currentPosition = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int nextPosition = currentPosition + distance;
            for (Node node : def) {
                if (currentPosition < node.end && nextPosition > node.start) {
                    int startPos = Math.max(currentPosition, node.start);
                    int endPos = Math.min(nextPosition, node.end);
                    if (startPos < endPos && speed > node.speed) {
                        maxSpeedDifference = Math.max(maxSpeedDifference, speed - node.speed);
                    }
                }
            }
            currentPosition = nextPosition;
        }

        System.out.print(maxSpeedDifference);
    }
}
