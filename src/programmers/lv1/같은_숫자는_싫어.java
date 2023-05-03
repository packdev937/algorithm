package programmers.lv1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        int[] arr = new int[]{1, 1, 3, 3, 0, 1, 1};

        for (int i = arr.length - 1; i >= 0; i--) {
            if (s.isEmpty())
                s.push(arr[i]);
            else {
                if (s.peek() == arr[i])
                    continue;
                else s.push(arr[i]);
            }
        }
        int[] answer = {};
        for (int i = 0; i < answer.length; i++) {
            answer[i] = s.pop();
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
