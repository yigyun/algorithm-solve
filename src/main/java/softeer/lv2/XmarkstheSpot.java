package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XmarkstheSpot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            String T = st.nextToken();
            for(int j = 0; j < S.length(); j++){
                char ch = S.charAt(j);
                if(ch == 'x' || ch == 'X'){
                    char chT = T.charAt(j);
                    if(Character.isAlphabetic(chT)){
                        chT = Character.toUpperCase(chT);
                        sb.append(chT);
                    }else sb.append(chT);
                }
            }
        }

        System.out.print(sb.toString());
    }
}
