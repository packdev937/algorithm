package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _2238 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 금액의 상한
        int U = Integer.parseInt(st.nextToken());
        // 경매에 참여한 횟수
        int N = Integer.parseInt(st.nextToken());

        // 이름과 제시한 가격
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            ArrayList<String> list = map.getOrDefault(price, new ArrayList<>());
            list.add(name);
            map.put(price, list);
        }

        List<Integer> orderedKeySet = map.keySet().stream()
            .sorted((a, b) -> {
	if (map.get(a).size() != map.get(b).size()) {
	    return map.get(a).size() - map.get(b).size();
	} else {
	    return a - b;
	}
            }).collect(Collectors.toList());

        int answerKey = orderedKeySet.get(0);
        System.out.println(map.get(answerKey).get(0) + " " + answerKey);
    }

}
