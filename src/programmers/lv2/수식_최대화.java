package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 수식_최대화 {
    private long answer = 0;

    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        String num = "";

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
	ops.add(c);
	numbers.add(Long.parseLong(num));
	num = "";
            } else {
	num += c;
            }
        }
        numbers.add(Long.parseLong(num));

        backtraking(numbers, ops, new char[]{'*', '+', '-'}, new char[3], new boolean[3], 0);
        return answer;
    }

    private void backtraking(List<Long> numbers, List<Character> ops, char[] options, char[] current, boolean[] used, int depth) {
        if (depth == 3) {
            answer = Math.max(answer, Math.abs(calculate(new ArrayList<>(numbers), new ArrayList<>(ops), current)));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!used[i]) {
	used[i] = true;
	current[depth] = options[i];
	backtraking(numbers, ops, options, current, used, depth + 1);
	used[i] = false;
            }
        }
    }

    private long calculate(List<Long> numbers, List<Character> ops, char[] priority) {
        for (char op : priority) {
            for (int i = 0; i < ops.size(); i++) {
	if (ops.get(i) == op) {
	    long res = op == '+' ? numbers.get(i) + numbers.get(i + 1) :
	        op == '-' ? numbers.get(i) - numbers.get(i + 1) :
	            numbers.get(i) * numbers.get(i + 1);
	    numbers.remove(i);
	    numbers.set(i, res);
	    ops.remove(i);
	    i--;
	}
            }
        }
        return numbers.get(0);
    }

    public static void main(String[] args) {
        수식_최대화 test = new 수식_최대화();
        System.out.println(test.solution("100-200*300-500+20"));
    }
}
