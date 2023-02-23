package inflearn.sorting_searching;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int N = sc.nextInt();
        Deque<Integer> cache = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            int s = cache.size();
            if (cache.contains(num)) {
                for (int j = 0; j < s; j++) {
                    int temp = cache.removeLast();
                    if (temp == num)
                        continue;
                    else cache.addFirst(temp);
                }
                cache.addFirst(num);
            } else {
                if (s < size) {
                    cache.addFirst(num);
                } else {
                    cache.removeLast();
                    cache.addFirst(num);
                }
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print(cache.removeFirst() + " ");
        }
    }
}
