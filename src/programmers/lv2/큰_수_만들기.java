package programmers.lv2;

import java.util.*;

public class 큰_수_만들기 {

    class Solution {
        public String solution(String number, int k) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < number.length(); i++) {
                char digit = number.charAt(i);
                while (!stack.isEmpty() && stack.peek() < digit && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(digit);
            }

            while (k-- > 0) {
                stack.pop();
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }


}
