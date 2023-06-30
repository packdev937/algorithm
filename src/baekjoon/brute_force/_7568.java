package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _7568 {
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            list.add(new int[]{weight, height});
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            int[] arr = list.get(i);
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                if (list.get(j)[0] > arr[0])
                    if (list.get(j)[1] > arr[1])
                        cnt++;
            }
            sb.append(cnt + " ");
        }
        System.out.println(sb);
    }
}
