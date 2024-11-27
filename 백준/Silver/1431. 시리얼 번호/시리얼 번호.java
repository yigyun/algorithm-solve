import java.util.*;
import java.io.*;

// 1번 길이가 다르면 짧은거 1번,
// 2번 길이가 같으면 A의 모든 자리수의 합, B의 모든 자리수의 합을 비교해서 작은 합
// 3번 1, 2번 둘 조건으로도 비교할 수 없으면, 사전순

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String[] strs = new String[N];
        for(int i = 0; i < N; i++){
            strs[i] = br.readLine();
        }

        Arrays.sort(strs, (o1, o2) -> {
            if(o1.length() == o2.length()){
                int c1 = 0;
                int c2 = 0;
                for(char ch : o1.toCharArray()){
                    if(Character.isDigit(ch)) c1 += ch - '0';
                }
                for(char ch : o2.toCharArray()){
                    if(Character.isDigit(ch)) c2 += ch - '0';
                }
                if(c1 == c2){
                    return o1.compareTo(o2) ;
                }
                return c1 - c2;
            }
            return o1.length() - o2.length();
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(strs[i]).append('\n');
        }
        System.out.print(sb.toString());
    }
}