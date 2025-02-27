import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num <= 0) minus.add(num);
            else plus.add(num);
        }

        Collections.sort(minus);
        Collections.sort(plus, (o1, o2) -> o2 - o1);

        int result = 0;

        for(int i = 0; i < minus.size()-1; i+=2){
            int num1 = minus.get(i);
            int num2 = minus.get(i+1);
            result += num1 * num2;
        }

        if(minus.size() % 2 == 1){
            result += minus.get(minus.size() - 1);
        }

        for (int i = 0; i < plus.size() - 1; i += 2) {
            int num1 = plus.get(i);
            int num2 = plus.get(i + 1);
            if (num1 * num2 > num1 + num2) {
                result += num1 * num2;
            } else {
                result += num1 + num2;
            }
        }

        if(plus.size() % 2 == 1){
            result += plus.get(plus.size() - 1);
        }

        System.out.print(result);
    }
}