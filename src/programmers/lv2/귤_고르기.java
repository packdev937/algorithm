package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class 귤_고르기 {

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        // 각 귤 크기의 개수를 카운팅
        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }

        // 귤의 개수를 기준으로 내림차순 정렬
        List<Integer> countList = new ArrayList<>(map.values());
        Collections.sort(countList, Collections.reverseOrder());

        int answer = 0;
        int total = 0;

        // 가장 많이 수확한 귤 크기부터 채우기
        for (int count : countList) {
            total += count;
            answer++;  // 사용한 크기 종류 1 추가
            if (total >= k) {
	break;
            }
        }

        return answer;
    }
}
