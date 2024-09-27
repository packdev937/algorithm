package programmers.lv2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 호텔_대실 {

    // 종료 시간을 기준으로 정렬
    Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    public int solution(String[][] book_time) {
        int[][] rooms = new int[book_time.length][2];

        // 예약 시간을 분 단위로 변환하여 rooms 배열에 저장
        for (int i = 0; i < rooms.length; i++) {
            rooms[i][0] = getMinutes(book_time[i][0]); // 시작 시간
            rooms[i][1] = getMinutes(book_time[i][1]); // 종료 시간
        }

        // 예약의 시작 시간을 기준으로 정렬
        Arrays.sort(rooms, (a, b) -> a[0] - b[0]);

        // 방 개수 초기화
        int answer = 0;

        // 첫 번째 예약을 큐에 추가
        queue.add(rooms[0]);
        answer = 1;

        // 나머지 예약에 대해 큐에서 방을 관리
        for (int i = 1; i < rooms.length; i++) {
            // 큐에 있는 방들 중 끝난 방을 제거 (종료 시간이 지나면)
            while (!queue.isEmpty() && rooms[i][0] >= queue.peek()[1] + 10) {
	queue.poll();
            }

            // 현재 예약을 큐에 추가
            queue.add(rooms[i]);

            // 최대 방 개수 업데이트
            answer = Math.max(answer, queue.size());
        }

        return answer;
    }

    // "HH:MM" 형식의 시간을 분 단위로 변환하는 메서드
    public int getMinutes(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        return hour * 60 + minute;
    }

}
