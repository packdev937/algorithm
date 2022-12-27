package baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

class Room implements Comparable<Room> {
    int sTime;
    int eTime;

    @Override
    public int compareTo(Room o) {
        if (this.sTime == o.sTime) {
            return this.eTime - o.eTime;
        }
        return this.sTime - o.sTime;
    }
}

public class _1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Room[] arr = new Room[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Room();
            arr[i].sTime = sc.nextInt();
            arr[i].eTime = sc.nextInt();
        }

        Arrays.sort(arr);
    }
}

// 회의실 배정
