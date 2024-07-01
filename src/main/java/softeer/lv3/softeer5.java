package softeer.lv3;

import java.util.Scanner;

public class softeer5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] grades = new int[N];

        for(int i = 0; i < N; i++){
            int num = sc.nextInt();
            if(i == 0) grades[i] = num;
            else grades[i] = grades[i-1] + num;
        }

        for(int i = 0; i < K; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            double result = 0;
            if(a == 1){
                result = (double)grades[b-1] / b;
            }else{
                result = (double)(grades[b-1] - grades[a-2]) / (b-a+1);
            }
            System.out.printf("%.2f\n", result);
        }

    }
}
