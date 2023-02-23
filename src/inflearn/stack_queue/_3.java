package inflearn.stack_queue;

import java.util.*;

public class _3 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N];
        int cnt = 0;

        // board 값 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // Moves 값 입력
        int M = sc.nextInt();
        int[] moves = new int[M];
        for (int i = 0; i < M; i++) {
            moves[i] = sc.nextInt();
        }

        // Game Start!
        for (int i = 0; i < M; i++) {
            int select = moves[i] - 1;
            for (int j = 0; j < N; j++) {
                int doll = board[j][select];
                if (doll != 0) {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == doll){
                            stack.pop();
                            cnt+=2;
                        }
                        else {
                            stack.add(doll);
                        }
                    } else stack.add(doll);
                    board[j][select] = 0;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
