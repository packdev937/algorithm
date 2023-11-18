package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _27172 {

    static int[] dp = new int[1000001];
    static boolean[] ch = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            list.add(number);
            ch[number] = true;
        }

        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            for (Integer j = number * 2; j < dp.length; j += number) {
	dp[j]--;
	if (ch[j]) {
	    dp[number]++;
	}
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(dp[list.get(i)]).append(" ");
        }
        System.out.println(sb.toString());
    }
}