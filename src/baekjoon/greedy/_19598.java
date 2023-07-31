package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _19598 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 회의 정보를 저장하는 배열
        Conference[] conferences = new Conference[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            conferences[i] = new Conference(start, end);
        }

        // 회의 시작 시간 기준으로 오름차순 정렬
        Arrays.sort(conferences, (c1, c2) -> Integer.compare(c1.start, c2.start));

        // 현재 진행 중인 회의들의 끝나는 시간을 저장하는 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            Conference current = conferences[i];
            if (!pq.isEmpty() && pq.peek() <= current.start) {
                pq.poll(); // 끝난 회의 제거
            } else {
                cnt++; // 새로운 회의실 할당
            }
            pq.offer(current.end); // 현재 회의를 끝나는 시간으로 저장
        }

        System.out.print(cnt);
    }

    static class Conference {
        int start;
        int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
