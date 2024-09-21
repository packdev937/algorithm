package programmers.lv2;

public class n2_배열_자르기 {

    class Solution {

        public int[] solution(int n, long left, long right) {
            int length = (int) (right - left + 1);
            int[] answer = new int[length];

            int idx = 0;
            for (long i = left; i <= right; i++) {
	int row = (int) i / n;
	int column = (int) i % n;
	answer[idx++] = Math.max(row, column) + 1;
            }

            return answer;
        }
    }
}
