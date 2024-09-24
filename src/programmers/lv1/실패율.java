package programmers.lv1;

import java.util.*;

public class 실패율 {

    public static int[] solution(int N, int[] stages) {
        // 반환할 답안을 위한 배열 초기화
        int[] answer = new int[N];

        // 각 스테이지에 도달한 사람 수를 저장하는 배열
        int[] total = new int[N + 1];
        Arrays.fill(total, stages.length); // 전체 사람 수로 초기화

        // 각 스테이지에 머물고 있는 사람의 수를 저장하는 Map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stages.length; i++) {
            map.put(stages[i], map.getOrDefault(stages[i], 0) + 1);
        }

        // 각 스테이지에 도달한 인원을 계산
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
	total[i] -= map.getOrDefault(j, 0);
            }
        }

        // 실패율을 저장할 리스트
        List<FailureRate> failureRates = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (total[i] > 0) {
	failureRates.add(new FailureRate(i, (double) map.getOrDefault(i, 0) / total[i]));
            } else {
	failureRates.add(new FailureRate(i, 0));
            }
        }

        // 실패율을 기준으로 정렬, 실패율이 같으면 스테이지 번호 오름차순으로 정렬
        Collections.sort(failureRates, (a, b) -> {
            if (Double.compare(b.rate, a.rate) == 0) {
	return Integer.compare(a.level, b.level); // 스테이지 번호 기준 오름차순
            }
            return Double.compare(b.rate, a.rate); // 실패율 기준 내림차순
        });

        // 정렬된 결과를 기반으로 answer 배열 채우기
        for (int i = 0; i < N; i++) {
            answer[i] = failureRates.get(i).level;
        }

        return answer;
    }
}

class FailureRate {

    int level;
    double rate;

    public FailureRate(int level, double rate) {
        this.level = level;
        this.rate = rate;
    }

    public static void main(String[] args) {
        실패율 T = new 실패율();
        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        int[] answer = T.solution(5, stages);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
