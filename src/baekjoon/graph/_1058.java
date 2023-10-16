package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _1058 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int answer = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (chars[j] == 'Y') {
                    graph.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, bfs(i));
        }
        System.out.println(answer);
    }

    public static int bfs(int i) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.add(new int[]{i, 0});
        int count = -1;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (temp[1] > 2) {
                continue;
            }
            if (visited[temp[0]]) {
                continue;
            }
            visited[temp[0]] = true;
            count++;
            for (int j = 0; j < graph.get(temp[0]).size(); j++) {
                queue.add(new int[]{graph.get(temp[0]).get(j), temp[1] + 1});
            }
        }
        return count;
    }
}

// 입력
// 1. 첫째 줄에 사람의 수 N을 입력한다
// 1-1. N은 50 이하의 자연수이다
// 2. N 또는 Y로 입력한다. 이 때, Y는 친구 관계를 의미한다
// 2-1. N 또는 Y 이외의 입력이 주어진다면 예외 처리 한다
// 출력
// 1. 제일 유명한 사람의 2-친구 수를 출력한다
// 1-1. 2 친구 수는 친구 관계거나, 친구의 친구 까지 허용된다
// 동작 기능
// 1. Y 또는 N에 따라 친구 관계를 매핑한다
// 2. 매핑됭 친구 관계를 이용하여 각 사람에 대한 2-친구 개수를 구한다
// 3. 친구의 친구는 depth로 구분한다
