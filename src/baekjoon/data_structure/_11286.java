package baekjoon.data_structure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int compareAbs = Math.abs(o1) - Math.abs(o2);
                if (compareAbs != 0)
                    return compareAbs;
                return o1 - o2;
            }
        });
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (!pq.isEmpty())
                    System.out.println(pq.poll());
                else System.out.println("0");
            } else pq.add(num);
        }
    }
}

// 헷갈릴 수 있는 포인트
// (1) Comparator 사용법
// (2) o1-o2 했을 때 정렬 순서
//  0 = 두 수는 같다. this.id - o.id (오름차순) o.id - this.id (내림차순)
// (3) CompareTo()와 compare()