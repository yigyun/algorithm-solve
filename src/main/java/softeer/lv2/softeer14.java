package softeer.lv2;

import java.util.Scanner;

public class softeer14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int n = sc.nextInt();
        int result = 0;

        int[] prices = new int[10001];

        for(int i = 0; i < n; i++){
            int weight = sc.nextInt();
            int price = sc.nextInt();
            prices[price] += weight;
        }

        for(int i = 10000; i > 0; i--){
            if(w - prices[i] > 0){
                result += prices[i] * i;
                w -= prices[i];
            }else{
                result += w * i;
                break;
            }
        }

        System.out.print(result);
    }
}
