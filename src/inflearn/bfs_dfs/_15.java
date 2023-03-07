package inflearn.bfs_dfs;

import java.util.Scanner;

public class _15 {
    public static int cntMin = 9999;
    public static int N, M;

    public static void bfs(int pos, int cnt) {
        if (pos == M) {
            if (cnt < cntMin) {
                cntMin = cnt;
            }
        }
        if (cnt >= cntMin) {
            return;
        } else {
            cnt++;
            if (M - pos >= 5)
                bfs(pos + 5, cnt);
            else {
                bfs(pos - 1, cnt);
                bfs(pos + 1, cnt);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        bfs(N, 0);
        System.out.print(cntMin);
    }
}

/*
초기의 Time Limit Exceeded는 거리 차가 5 이상일 땐 5로만 가지가 뻗어나가도록 조치하여 해결하였음

8 3 일 때는 해결이 안됨
-1 1 순서를 바꿔주었음
 */