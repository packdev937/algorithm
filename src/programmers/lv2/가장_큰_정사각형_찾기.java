package programmers.lv2;

public class 가장_큰_정사각형_찾기 {

    class Solution {

        public int solution(int[][] board) {
            int answer = 0;
            // 이거 뺴먹음
            if (board.length < 2 || board[0].length < 2) {
	return 1;
            }

            for (int i = 1; i < board.length; i++) {
	for (int j = 1; j < board[i].length; j++) {
	    // 이거 뺴먹음
	    if (board[i][j] != 0) {
	        board[i][j] = Math.min(board[i - 1][j - 1],
	            Math.min(board[i][j - 1], board[i - 1][j])) + 1;
	    }
	    answer = Math.max(answer, board[i][j]);
	}
            }

            return answer * answer;
        }
    }

}
