package baekjoon.implementation;

import java.util.Scanner;

public class _1094 {

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        int total = 64;
        int min = 64;
        int current = 0;

        int cnt = 0;
        while (true) {
            if(total - current == N){
                break;
            }
            current = min / 2;
            cnt++;
            if (total - current > N) {
                total -= current;
                cnt--;
            }
            min = current;
        }

        System.out.println(cnt==0?1:cnt);
    }
}