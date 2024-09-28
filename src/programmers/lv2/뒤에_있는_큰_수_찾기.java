package programmers.lv2;

public class 뒤에_있는_큰_수_찾기 {

    class Solution {

        int highest = Integer.MIN_VALUE;

        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];

            answer[answer.length - 1] = -1;

            for (int i = answer.length - 1; i >= 1; i--) {
	highest = Math.max(highest, numbers[i]);

	if (numbers[i] > numbers[i - 1]) {
	    answer[i - 1] = numbers[i];
	}

	if (numbers[i] == numbers[i - 1]) {
	    answer[i - 1] = answer[i];
	}

	if (numbers[i] < numbers[i - 1]) {

	    if (numbers[i - 1] > highest) {
	        answer[i - 1] = -1;
	        continue;
	    }

	    int idx = i;
	    while (idx < numbers.length) {
	        if (numbers[i - 1] < answer[idx]) {
	            answer[i - 1] = answer[idx];
	            break;
	        }

	        idx++;
	        answer[i - 1] = -1;
	    }
	}
            }

            return answer;
        }
    }
}
