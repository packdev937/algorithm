package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 오름차순으로 정렬
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        // 첫 번째 수는 그냥 입력 받음
        int median = Integer.parseInt(br.readLine());
        sb.append(median + "\n");

        for (int i = 1; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp > median)
                minHeap.offer(temp);
            else maxHeap.offer(temp);

            // 각각의 차이가 2이상 벌어지면
            if (minHeap.size() - 1 > maxHeap.size()) {
                maxHeap.offer(median);
                median = minHeap.poll();
            } else if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(median);
                median = maxHeap.poll();
            }
            sb.append(median + "\n");
        }
        System.out.println(sb);
    }
}
