package programmers.lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 두_큐_합_같게_만들기 {

    public static Deque<Integer> q1 = new ArrayDeque<>();
    public static Deque<Integer> q2 = new ArrayDeque<>();

    public static int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;

        for (int i : queue1) {
            q1.add(i);
            sum1 += i;
        }

        for (int i : queue2) {
            q2.add(i);
            sum2 += i;
        }
        long target = (sum1 + sum2) / 2;
        int cnt = 0;

        while (true) {
            if (cnt >= queue1.length * 3) {
                return -1;
            }
            if (sum1 == target || sum2 == target) {
                break;
            }
            if (sum1 > sum2) {
                q2.addLast(q1.pollFirst());
                sum1 -= q2.peekLast();
                sum2 += q2.peekLast();
            } else if (sum1 < sum2) {
                q1.addLast(q2.pollFirst());
                sum2 -= q1.peekLast();
                sum1 += q1.peekLast();
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] queue1 = new int[]{3, 7};
        int[] queue2 = new int[]{5, 3};

        System.out.print(solution(queue1, queue2));
    }
}
