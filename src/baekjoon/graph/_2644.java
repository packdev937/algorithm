package baekjoon.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2644 {
    private static int[] ch;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    private static Queue<Integer> Q = new LinkedList<>();
    static int cnt, x, y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ch = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 구해야 하는 관계
        x = sc.nextInt();
        y = sc.nextInt();

        // 관계의 개수
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        System.out.println(BFS());
    }

    public static int BFS() {
        boolean isTrue = false;
        Q.add(x);
        ch[x] = 1;

        // BFS에서 각 단계별로 한번씩만 ++
        while (!Q.isEmpty()) {
            int temp = Q.poll();
            if (temp == y) {
                isTrue = true;
                break;
            }
            for (int i = 0; i < graph.get(temp).size(); i++) {
                if (ch[graph.get(temp).get(i)] == 0) {
                    ch[graph.get(temp).get(i)] = ch[temp] + 1;
                    Q.add(graph.get(temp).get(i));
                }
            }
        }
        if (isTrue)
            return ch[y]-1;
        else return -1;
    }
}
