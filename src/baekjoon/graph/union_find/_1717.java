package baekjoon.graph.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1717 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (option) {
	case 0:
	    union(a, b);
	    break;
	case 1:
	    if (find(a) == find(b)) {
	        System.out.println("YES");
	        break;
	    }

	    System.out.println("NO");
	    break;
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            parent[b] = a;
            return;
        }

        parent[a] = b;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }


}
