package inflearn.greedy;

import java.util.*;

class Lecture implements Comparable<Lecture> {
    public int pay, day;

    public Lecture(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture o) {
        if (this.day == o.day) {
            return o.pay - this.pay;
        } else return o.day - this.day;
    }
}

public class _4 {
    private static PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Lecture> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(new Lecture(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);

        int j = 0;
        int total = 0;
        for (int i = list.get(0).day; i >= 1; i--) {
            for (; j < N; j++) {
                if (list.get(j).day < i) break;
                else {
                    PQ.offer(list.get(j).pay);
                }
            }
            if (!PQ.isEmpty())
                total += PQ.poll();
        }

        System.out.println(total);
    }
}
