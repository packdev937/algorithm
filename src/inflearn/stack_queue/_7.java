package inflearn.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _7 {
    public static void main(String[] args) {
        Deque<Character> sequence = new ArrayDeque<>();
        Deque<Character> architecture = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        for (char c : sc.next().toCharArray()) {
            sequence.addLast(c);
        }

        for (char c : sc.next().toCharArray()) {
            architecture.addLast(c);
        }

        while (!architecture.isEmpty()) {
            if(sequence.isEmpty()) break;
            char c = architecture.removeFirst();
            if (c == sequence.peekFirst()) {
                sequence.removeFirst();
            }
        }
        if (sequence.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }
}
