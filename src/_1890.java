import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1890 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
	board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1; // 시작점에서의 경로 수는 1

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
	if (dp[i][j] == 0 || (i == N - 1 && j == N - 1)) {
	    continue;
	}

	int distance = board[i][j];
	if (i + distance < N) {
	    dp[i + distance][j] += dp[i][j];
	}
	if (j + distance < N) {
	    dp[i][j + distance] += dp[i][j];
	}
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }

}
