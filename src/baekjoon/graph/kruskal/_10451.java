package baekjoon.graph.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10451 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] parent = new int[N + 1];
            for (int j = 0; j < N + 1; j++) {
	parent[j] = j;
            }
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
	if (!union(parent, j, Integer.parseInt(st.nextToken()))) {
	    cnt++;
	}
            }
            System.out.println(cnt);
        }
    }

    public static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent, parent[x]);
        }
    }

    public static boolean union(int[] parent, int a, int b) {
        int x = find(parent, a);
        int y = find(parent, b);

        if (x != y) {
            if (x > y) {
	parent[y] = x;
            } else {
	parent[x] = y;
            }
            return true;
        }

        return false;
    }

}
