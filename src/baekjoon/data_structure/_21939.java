package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _21939 {
    static Map<Integer, Integer> map = new HashMap<>();
    static PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    static PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1] != 0 ? b[1] - a[1] : a[0] - b[0]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int problemNum = Integer.parseInt(s[0]);
            int difficulty = Integer.parseInt(s[1]);
            map.put(problemNum, difficulty);
            minHeap.offer(new int[]{problemNum, difficulty});
            maxHeap.offer(new int[]{problemNum, difficulty});
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "add":
                    int problemNum = Integer.parseInt(s[1]);
                    int difficulty = Integer.parseInt(s[2]);
                    map.put(problemNum, difficulty);
                    minHeap.offer(new int[]{problemNum, difficulty});
                    maxHeap.offer(new int[]{problemNum, difficulty});
                    break;
                case "recommend":
                    if (s[1].equals("1")) {
                        while (!maxHeap.isEmpty()) {
                            int[] maxProblem = maxHeap.peek();
                            if (map.containsKey(maxProblem[0])) {
                                System.out.println(maxProblem[0]);
                                break;
                            } else {
                                maxHeap.poll();
                            }
                        }
                    } else {
                        while (!minHeap.isEmpty()) {
                            int[] minProblem = minHeap.peek();
                            if (map.containsKey(minProblem[0])) {
                                System.out.println(minProblem[0]);
                                break;
                            } else {
                                minHeap.poll();
                            }
                        }
                    }
                    break;
                case "solved":
                    int solvedNum = Integer.parseInt(s[1]);
                    map.remove(solvedNum);
                    break;
            }
        }
    }
}
