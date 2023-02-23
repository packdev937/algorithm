package inflearn.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class _4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack();
        int answer;

        for (char x : sc.next().toCharArray()) {
            if (Character.isDigit(x))
                s.add(Character.getNumericValue(x));
            else {
                switch (x) {
                    case '+':
                        int n1 = s.pop();
                        int n2 = s.pop();
                        s.add(n1 + n2);
                        break;
                    case '-':
                        n1 = s.pop();
                        n2 = s.pop();
                        s.add(n2 - n1);
                        break;
                    case '*':
                        n1 = s.pop();
                        n2 = s.pop();
                        s.add(n1 * n2);
                        break;
                    case '/':
                        n1 = s.pop();
                        n2 = s.pop();
                        s.add(n2 / n1);
                        break;
                }
            }
        }
        System.out.println(s.pop());
    }
}
