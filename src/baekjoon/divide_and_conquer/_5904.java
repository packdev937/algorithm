package baekjoon.divide_and_conquer;

import java.util.Scanner;

public class _5904 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // Initialization
        int length = 3;
        int prev = 3;
        int k = 0;

        //  n의 범위를 구해주기
        while (length < N) {
            k++;
            prev = length;
            length = 2 * prev + (1 + 2 + k); // S(K-1) * 2 + (moo...o)
        }

        Moo(length, k);
    }

    private static void Moo(int length, int k) {
        int prev = (length - (1 + 2 + k)) / 2; // 중간을 제외한 moo 크기를 구함
        if (k == 0) {
            if (N == 1) {
                System.out.print("m");
                return;
            } else {
                System.out.print("o");
                return;
            }
        }
        if (N <= prev) {
            Moo(prev, k - 1);
        } else if (prev + 1 <= N && N < prev + (1 + 2 + k)) { // prev + (moo...o)
            if (prev + 1 == N) {
                System.out.print('m');
            } else {
                System.out.print('o');
            }
        } else { // 앞 쪽에 있거나 뒤 쪽에 있는 경우
            N -= (prev + (1 + 2 + k));
            Moo(prev, k - 1);
        }
    }
}