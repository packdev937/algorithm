package baekjoon.sort;

import java.util.HashMap;
import java.util.Scanner;

public class _1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Boolean> map = new HashMap<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            map.put(sc.nextInt(), true);
        }

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            if (map.getOrDefault(x, false)) {
                System.out.println("1");
            } else System.out.println("0");
        }
    }
}
