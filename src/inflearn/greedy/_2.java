package inflearn.greedy;

import java.util.Scanner;
import java.util.TreeSet;

class Office implements Comparable<Office> {
    int st, et;

    public Office(int st, int et) {
        this.st = st;
        this.et = et;
    }

    @Override
    public int compareTo(Office o) {
        if (this.et == o.et) {
            return this.st - o.st;
        } else return this.et - o.et;
    }
}

public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        TreeSet<Office> tSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            tSet.add(new Office(sc.nextInt(), sc.nextInt()));
        }

        int cnt = 1;
        Office first = tSet.pollFirst();
        int len = tSet.size();
        for (int i = 0; i < len; i++) {
            Office second = tSet.pollFirst();
            if (second.st >= first.et) {
                first = second;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
