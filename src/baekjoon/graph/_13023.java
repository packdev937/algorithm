package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _13023 {
    static List<Integer>[] graph;
    static boolean[] ch;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            ch = new boolean[N];
            dfs(i, 0);
        }
        System.out.println(0);
    }

    public static void dfs(int i, int depth) {
        if (depth == 4) { // 이게 4 여야 한다.
            System.out.println(1);
            System.exit(0);
        }
        ch[i] = true;
        for (int j = 0; j < graph[i].size(); j++) {
            int temp = graph[i].get(j);
            if (!ch[temp]) {
                ch[temp] = true;
                dfs(temp, depth + 1);
                ch[temp] = false;
            }
        }
    }
}

// A-> B-> C-> D-> E가 다 연결되어야 한다