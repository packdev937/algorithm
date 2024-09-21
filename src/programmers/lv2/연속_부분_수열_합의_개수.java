package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {

    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int n = elements.length;

        // 모든 길이의 부분 배열을 계산 (길이는 1부터 n까지)
        for (int length = 1; length <= n; length++) {
            // 시작 위치 i를 기준으로 부분합 계산
            for (int i = 0; i < n; i++) {
	int sum = 0;
	// 길이 length만큼의 부분합 계산 (원형 배열로 돌아가야 함)
	for (int j = 0; j < length; j++) {
	    sum += elements[(i + j) % n];  // 원형 배열 처리
	}
	set.add(sum);  // 부분합을 Set에 추가 (중복 제거)
            }
        }

        return set.size();  // 모든 고유한 부분합의 개수 반환
    }
}

