package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _29336 {

    static int day = 0;
    static int answer = 0;
    static Integer[] quality;
    static int[][] condition;
    static boolean[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Initialization
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        quality = new Integer[N];
        ch = new boolean[N];
        condition = new int[M][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            quality[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(quality, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            condition[i][0] = Integer.parseInt(st.nextToken());
            condition[i][1] = Integer.parseInt(st.nextToken());
        }

        // Solution
        int idx = 0;
        int nIdx = 0;
        int qualitySum = 0;
        while (day <= condition[condition.length - 1][0]) {
            if (day == condition[idx][0]) {
                int target = condition[idx][1];
                target -= qualitySum;
                while (target > 0 && nIdx < quality.length) {
                    target -= quality[nIdx];
                    ch[nIdx] = true;
                    qualitySum += quality[nIdx];
                    nIdx++;
                }
                if (target > 0) {
                    System.out.println(-1);
                    return;
                }
                idx++;
            }
            if (idx == condition.length) {
                break;
            }
            plusQuality();
            day++;
        }
        for (int i = 0; i < quality.length; i++) {
            if (!ch[i]) {
                qualitySum += quality[i];
            }
        }
        System.out.println(qualitySum);
    }

    public static void plusQuality() {
        for (int i = 0; i < quality.length; i++) {
            if (ch[i]) {
                continue;
            }
            quality[i]++;
        }
    }
}

// 1 3 4 6
// 2 4 5 7
// 3 5 6
// 4 6 7
// 5 7 7 7