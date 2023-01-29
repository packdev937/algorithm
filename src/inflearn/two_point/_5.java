package inflearn.two_point;

import java.util.Scanner;

public class _5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int lt = 1, rt = 1;
        int total = 0, cnt = 0;

        while (true) {
            if (total < N) {
                total += rt++;
            } else if (total >= N) {
                if (total == N) cnt++;
                total -= lt++;
            }

            if(lt > (N+1)/2)
                break;
        }
        System.out.println(cnt);
    }
}
