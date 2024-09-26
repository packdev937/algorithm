package programmers.lv2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 숫자_변환하기 {

    Queue<int[]> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();

    public int solution(int x, int y, int n) {
        int answer = Integer.MAX_VALUE;

        queue.add(new int[]{y, 0});
        visited.add(y);  // 시작점 방문 처리

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            if (temp[1] > answer) {
	continue;
            }

            if (temp[0] == x) {
	answer = Math.min(answer, temp[1]);
	continue;
            }

            if (temp[0] < x) {
	continue;
            }

            // 나누기 2 가능하고 방문하지 않았다면
            if (temp[0] % 2 == 0 && !visited.contains(temp[0] / 2)) {
	queue.add(new int[]{temp[0] / 2, temp[1] + 1});
	visited.add(temp[0] / 2);
            }

            // 나누기 3 가능하고 방문하지 않았다면
            if (temp[0] % 3 == 0 && !visited.contains(temp[0] / 3)) {
	queue.add(new int[]{temp[0] / 3, temp[1] + 1});
	visited.add(temp[0] / 3);
            }

            // 빼기 n 가능하고 방문하지 않았다면
            if (temp[0] - n >= x && !visited.contains(temp[0] - n)) {
	queue.add(new int[]{temp[0] - n, temp[1] + 1});
	visited.add(temp[0] - n);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
