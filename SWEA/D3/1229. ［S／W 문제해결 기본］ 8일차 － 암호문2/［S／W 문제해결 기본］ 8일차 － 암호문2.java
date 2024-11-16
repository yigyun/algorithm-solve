
import java.util.*;
import java.io.*;

class Solution {    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {    

        	StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                String order = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                if (order.equals("D")) {
                    for (int j = 0; j < y; j++) {
                        if (x < list.size()) {
                            list.remove(x);
                        }
                    }
                } else if (order.equals("I")) {
                    for (int j = 0; j < y; j++) {
                        int value = Integer.parseInt(st.nextToken());
                        if (x <= list.size()) {
                            list.add(x++, value);
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Math.min(list.size(), 10); i++) {
                sb.append(list.get(i)).append(" ");
            }

            System.out.println("#" + test_case + " " + sb.toString().trim());
        }
    }
}
