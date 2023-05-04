package programmers.lv2;

import java.util.*;

class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> cache = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        for (int i = 0; i < cities.length; i++) {
            if (cache.remove(cities[i])) {
                cache.addLast(cities[i]);
                answer += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cache.pollFirst();
                }
                if (cacheSize != 0) {
                    cache.addLast(cities[i]);
                }
                answer += 5;
            }
        }
        return answer;
    }
}