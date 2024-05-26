package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1476 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int year = 1;
        while (true) {
            if (calculateYear(year, E, S, M)) {
	break;
            }
            year++;
        }

        System.out.println(year);
    }

    public static boolean calculateYear(int year, int E, int S, int M) {
        int calculatedE = year % 15 == 0 ? 15 : year % 15;
        int calculatedS = year % 28 == 0 ? 28 : year % 28;
        int calculatedM = year % 19 == 0 ? 19 : year % 19;

        return calculatedE == E && calculatedM == M && calculatedS == S;
    }
}

// https://www.acmicpc.net/problem/1476
/**
 * 예외 처리 : year = 1 선언 후 바로 year++로 접근해 1을 검증할 수가 없었습니다.
 */
