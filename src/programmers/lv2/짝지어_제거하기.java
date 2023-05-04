package programmers.lv2;

import java.util.Stack;

public class 짝지어_제거하기 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String s = "cdcd";

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.peek() == s.charAt(i))
                    stack.pop();
                else stack.push(s.charAt(i));
            }
        }
        System.out.println(stack.isEmpty());
    }
}
