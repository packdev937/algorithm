package baekjoon.data_structure;

import java.util.Scanner;

public class _1717 {
    static int[] parent;

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;

        }
    }

    static boolean isSameParent(int a, int b) {
        return find(a) == find(b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n + 1];
        // 여기서 n+1까지 인데 n까지 선언해서 틀린 듯
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int opt = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (opt == 0) {
                union(a, b);
            } else {
                if (isSameParent(a, b))
                    System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}