package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class _5 {
    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        Scanner sc = new Scanner(System.in);

        int total = 0;
        int cnt = 0;
        char temp = 'c';

        for (char c : sc.next().toCharArray()) {
            if (c == '(') {
                s.add(c);
                cnt++;
            } else if (c == ')') {
                s.pop();
                cnt--;
                if (temp == '(')
                    total += cnt;
                else total++;
            }
            temp = c;
        }
        System.out.println(total);
    }
}
