package programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 할인_행사 {

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> discountMap = new HashMap<>();

        // Initialize discountMap
        for (int i = 0; i < 10; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            if (i > 0) {
	discountMap.put(discount[i + 9], discountMap.getOrDefault(discount[i + 9], 0) + 1);
	discountMap.put(discount[i - 1], discountMap.get(discount[i - 1]) - 1);
            }

            if (compare(want, number, discountMap)) {
	answer++;
            }
        }

        return answer;
    }

    public static boolean compare(String[] want, int[] number, Map<String, Integer> discountMap) {
        boolean isTrue = true;
        for (int i = 0; i < want.length; i++) {
            if (!discountMap.containsKey(want[i]) || discountMap.get(want[i]) != number[i]) {
	isTrue = false;
	break;
            }
        }

        return isTrue;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork",
            "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(solution(want, number, discount));
    }

}
