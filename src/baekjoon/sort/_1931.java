package baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Conference implements Comparable<Conference> {

    int sTime;
    int eTime;

    @Override
    public int compareTo(Conference o) {
        if (this.eTime - o.eTime != 0) {
            return this.eTime - o.eTime;
        }
        return this.sTime - o.sTime;
    }
}

public class _1931 {

    static Stack<Conference> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Conference[] arr = new Conference[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Conference();
            arr[i].sTime = sc.nextInt();
            arr[i].eTime = sc.nextInt();
        }

        Arrays.sort(arr);
        int idx = 0;
        int cnt = 1;
        stack.push(arr[idx++]);

        while (idx < arr.length) {
            if (arr[idx].sTime >= stack.peek().eTime) {
                stack.push(arr[idx]);
                cnt++;
            }
            idx++;
        }
        System.out.println(stack.size());
    }
}

// 회의실 배정
//1 4
//3 5
//0 6
//5 7
//3 8
//5 9
//6 10
//8 11
//8 12
//2 13
//12 14