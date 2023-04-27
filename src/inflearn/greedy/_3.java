package inflearn.greedy;

import java.util.Arrays;
import java.util.Scanner;

class Friend implements Comparable<Friend> {
    public int arrive, leave;

    public Friend(int arrive, int leave) {
        this.arrive = arrive;
        this.leave = leave;
    }

    @Override
    public int compareTo(Friend o) {
        if (this.arrive == o.arrive) {
            return this.leave - o.leave;
        } else return this.arrive - o.arrive;
    }
}

public class _3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Friend[] arr = new Friend[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Friend(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(arr);
        int current = 0;
        int maxCurrent = 0;

        for (int i = arr[0].arrive; i < arr[arr.length - 1].leave; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].arrive == i)
                    current++;
                if (arr[j].leave == i)
                    current--;
                if (current > maxCurrent)
                    maxCurrent = current;
            }
        }
        System.out.println(maxCurrent);
    }
}
