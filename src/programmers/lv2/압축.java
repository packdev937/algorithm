package programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 압축 {

    class Solution {

        HashMap<String, Integer> map = new HashMap<>();

        public int[] solution(String msg) {
            List<Integer> list = new ArrayList<>();

            // Initialization: A-Z를 1부터 26까지 매핑
            for (int i = 0; i < 26; i++) {
	map.put(String.valueOf((char) (65 + i)), i + 1);
            }

            int current = 0;
            while (current < msg.length()) {
	String longest = "";
	int length = 0;

	// 사전에 있는 가장 긴 문자열 찾기
	for (int j = 1; current + j <= msg.length(); j++) {
	    String substr = msg.substring(current, current + j);
	    if (map.containsKey(substr)) {
	        longest = substr;
	        length = j;
	    } else {
	        break;
	    }
	}

	// 가장 긴 문자열의 인덱스 추가
	list.add(map.get(longest));

	// 사전에 새로운 문자열 추가
	if (current + length < msg.length()) {
	    String newStr = msg.substring(current, current + length + 1);
	    map.put(newStr, map.size() + 1);
	}

	// 현재 위치를 업데이트
	current += length;
            }

            // List<Integer> to int[] 변환
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }

}
