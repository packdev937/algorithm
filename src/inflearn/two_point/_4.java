package inflearn.two_point;

import java.util.Scanner;

public class _4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int total = 0, cnt = 0;
        int lt = 0, rt = 0;
        while (true) {
            if (total < M) {
                total += arr[rt++];
            } else if (total >= M) {
                if (total == M) cnt++;
                total -= arr[lt++];
            }
            if (rt == N && total < M)
                break;
        }
        System.out.println(cnt);
    }
}
