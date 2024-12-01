package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _13015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 첫째 줄
        printFirstAndLastLine(N);
        // 중간 줄
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j < i; j++) {
	printBlank();
            }
            printGap(N);
            for (int j = 0; j < 2 * (N - i) - 3; j++) {
	printBlank();
            }
            printGap(N);
            System.out.println();
        }
        // 완전 중간 줄
        printMiddle(N);

        // 중간 줄
        for (int i = N - 2; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
	printBlank();
            }
            printGap(N);
            // 다음 코드가 틀렸었음
            /*
               for (int j = 0; j < N - 2 * (i - 1); j++) {
	    printBlank();
               }
             */
            for (int j = 0; j < 2 * (N - i) - 3; j++) {
	printBlank();
            }
            printGap(N);
            System.out.println();
        }
        // 마지막 줄
        printFirstAndLastLine(N);
    }

    private static void printFirstAndLastLine(int N) {
        for (int i = 0; i < N; i++) {
            printStar();
        }
        for (int i = 0; i < (N - 2) * 2 + 1; i++) {
            printBlank();
        }
        for (int i = 0; i < N; i++) {
            printStar();
        }
        System.out.println();
    }

    private static void printStar() {
        System.out.print("*");
    }

    private static void printBlank() {
        System.out.print(" ");
    }

    private static void printGap(int N) {
        printStar();
        for (int i = 0; i < N - 2; i++) {
            printBlank();
        }
        printStar();
    }

    private static void printMiddle(int N) {
        for (int i = 0; i < N - 1; i++) {
            printBlank();
        }
        printStar();
        for (int i = 0; i < N - 2; i++) {
            printBlank();
        }
        printStar();
        for (int i = 0; i < N - 2; i++) {
            printBlank();
        }
        printStar();
        System.out.println();
    }
}