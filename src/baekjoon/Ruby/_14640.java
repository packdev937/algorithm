package baekjoon.Ruby;

import java.util.*;

public class _14640 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int currentEnd = -1000000000;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            if (start + t > end) {
                flag = false;
                break;
            }
            if (start > currentEnd) {
                currentEnd = end;
            } else if (currentEnd > end) {
                currentEnd = end;
            } else {
                currentEnd = currentEnd + t;
            }
            if (currentEnd > 1000000000) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
