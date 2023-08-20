package programmers.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 예상_대진표 {
    private static Queue<Integer> q = new LinkedList<>();

    public static int solution(int n, int a, int b) {
        for (int i = 0; i < n; i++) {
            q.add(i + 1);
        }
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        q.add(-1);
        int cnt = 0;
        while (!q.isEmpty()) {
            int player1 = q.poll();
            if (player1 == -1) {
                cnt++;
                q.add(-1);
                continue;
            }
            int player2 = q.poll();

            if (player1 == a && player2 == b) {
                cnt++;
                break;
            }
            if (player1 == a || player1 == b) {
                q.add(player1);
            } else if (player2 == a || player2 == b) {
                q.add(player2);
            } else q.add(player1);
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(solution(N, A, B));
    }
}
