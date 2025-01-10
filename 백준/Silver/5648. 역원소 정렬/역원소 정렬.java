import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(); // 정답용

        // 첫줄만 따로 처리하기
        int n = sc.nextInt();
        long[] nums = new long[n];  // 원래 크기로 복원
        int index = 0;

        // 첫 줄의 나머지 숫자들 처리
        while (index < n) {
            nums[index++] = Long.parseLong(new StringBuilder(sc.next()).reverse().toString());
        }

        Arrays.sort(nums);

        for (long num : nums) {
            sb.append(num).append('\n');
        }

        System.out.print(sb);
    }
}