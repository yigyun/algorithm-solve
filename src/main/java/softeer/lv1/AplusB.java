package softeer.lv1;

import java.util.Scanner;

public class AplusB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int result = A+B;
            System.out.println("Case " + "#" + i + ": " + result);
        }
    }
}
