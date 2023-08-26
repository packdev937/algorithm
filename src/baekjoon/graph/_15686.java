package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _15686 {

    static ArrayList<int[]> selected = new ArrayList<>();
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static int N, M;
    static boolean[] ch;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    home.add(new int[]{i, j});
                } else if (val == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        ch = new boolean[chicken.size()];
        backtracking(0, 0);
        System.out.println(ans);
    }

    public static void backtracking(int index, int start) {
        if (index == M) {
            ans = Math.min(ans, calculate());
            return;
        }

        for (int j = start; j < chicken.size(); j++) {
            if (!ch[j]) {
                ch[j] = true;
                selected.add(chicken.get(j));
                backtracking(index + 1, j + 1);
                ch[j] = false;
                selected.remove(selected.size() - 1);
            }
        }
    }

    public static int calculate() {
        int totalDist = 0;

        for (int[] h : home) {
            int minDist = Integer.MAX_VALUE;
            for (int[] c : selected) {
                int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                minDist = Math.min(minDist, dist);
            }
            totalDist += minDist;
        }

        return totalDist;
    }
}