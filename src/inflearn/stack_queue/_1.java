package inflearn.stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class _1 {
    public static void main(String[] args) {
        Queue<Character> stack = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        for(char x : sc.next().toCharArray()){
            if(x == '(')
                stack.add('(');
            else {
                if(stack.isEmpty()){
                    stack.add('X');
                    break;
                }
                stack.poll();
            }
        }
        if(stack.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }
}
