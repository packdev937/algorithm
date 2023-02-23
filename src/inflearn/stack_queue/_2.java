package inflearn.stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Character> stack = new ArrayDeque<>();
        String answer = "";

        for (char x : sc.next().toCharArray()) {
            if (x == '(') stack.add(x);
            else if (x == ')') stack.poll();
            else {
                if (stack.isEmpty())
                    answer += x;
            }
        }
        System.out.println(answer);
    }
}
