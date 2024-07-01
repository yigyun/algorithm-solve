package softeer.lv2;

import java.util.Scanner;

public class softeer15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        long p = sc.nextLong();
        int n = sc.nextInt();

        long result = k;
        for(int i = 0; i < n; i++){
            result = (result * p) % 1000000007;
        }
        System.out.print(result);
    }
}
