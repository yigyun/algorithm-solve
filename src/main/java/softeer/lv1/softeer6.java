package softeer.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class softeer6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int hour = 0;
        int minute = 0;
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String[] str = st.nextToken().split(":");
            int fh = Integer.parseInt(str[0]);
            int fm = Integer.parseInt(str[1]);
            str = st.nextToken().split(":");
            int sh = Integer.parseInt(str[0]);
            int sm = Integer.parseInt(str[1]);
            hour += sh - fh;
            minute += sm - fm;
            if(hour == 0 && minute == 0) minute += 1;
        }

        System.out.print(minute + (hour * 60));
    }
}
