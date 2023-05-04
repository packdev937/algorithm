package programmers.lv2;

import java.util.Stack;

public class 올바른_괄호 {
    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push('(');
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                } else
                    stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("(()("));
    }
}
