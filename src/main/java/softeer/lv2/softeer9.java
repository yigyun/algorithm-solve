package softeer.lv2;

import java.util.Scanner;

public class softeer9 {
    public static void main(String[] args) {
        int start = 4; int dif = 7;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = 0;
        for(int i = 1; i <= n; i++){
            int side = (int)Math.sqrt(start);
            start = start + ((start - side) * 2) + ((start - (side * 2) + 1));
        }

        System.out.print(start);
    }
}
