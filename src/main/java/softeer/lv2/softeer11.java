package softeer.lv2;

import java.util.Scanner;

public class softeer11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag = 0; // a 0 d 1 m 2
        int num = sc.nextInt();
        int num2 = sc.nextInt();
        if(num - num2 > 0) flag = 1;
        for(int i = 0; i < 6; i++){
            num = sc.nextInt();
            if(num2 - num > 0){
                if(flag != 1) {flag = 2; break;}
                num2 = num;
            } else if(num2 - num < 0){
                if(flag != 0){flag = 2; break;}
                num2 = num;
            }
        }

        if(flag == 0) System.out.print("ascending");
        else if(flag == 1) System.out.print("descending");
        else System.out.print("mixed");

    }
}
