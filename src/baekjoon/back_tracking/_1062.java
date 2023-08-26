package baekjoon.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1062 {

    static int N, K;
    static int max = 0;
    static int[] words;
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        K -= 5;
        words = new int[N];

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (char c : word.toCharArray()) {
                words[i] |= (1 << (c - 'a'));
            }
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['t' - 'a'] = true;

        dfs(0, 0);

        System.out.println(max);
    }

    public static void dfs(int index, int count) {
        if (count == K) {
            int readable = 0;
            for (int word : words) {
                if ((word & ~convertToMask()) == 0) {
                    readable++;
                }
            }
            max = Math.max(max, readable);
            return;
        }

        for (int i = index; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, count + 1);
                visited[i] = false;
            }
        }
    }

    public static int convertToMask() {
        int mask = 0;
        for (int i = 0; i < 26; i++) {
            if (visited[i]) {
                mask |= (1 << i);
            }
        }
        return mask;
    }
}

// 백 트래킹 조합, 비트 마스킹 시간 초과 제외