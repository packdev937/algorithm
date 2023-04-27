package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class _01 {
    static TreeSet<Integer> tSet = new TreeSet<>();
    static int[] D = new int[100001];
    static int lastNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(">> Input the number of numbers to process: ");
        int N;

        // 1
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N < 1 || N > 30) {
                System.out.print(">> Input the number again: ");
            } else break;
        }

        // 2
        System.out.println(">> Input the numbers to be processed");
        String[] input;
        boolean isLenTrue;
        boolean isRangeTrue;

        while (true) {
            isLenTrue = false;
            isRangeTrue = true;

            input = br.readLine().split(" ");
            if (input.length == N)
                isLenTrue = true;

            for (int i = 0; i < input.length; i++) {
                if (Integer.parseInt(input[i]) > 100000 || Integer.parseInt(input[i]) < 1) {
                    isRangeTrue = false;
                    break;
                }
            }

            if (isLenTrue && isRangeTrue)
                break;
            else System.out.println(">> Input the numbers to be processed again ");
        }

        // 3
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(input[i]);
            tSet.add(temp);
        }

        int first = tSet.pollFirst();
        int second = 0;
        int len = tSet.size();
        lastNum = tSet.last();
        calculatePrimeNumber();
        for (int i = 0; i < len; i++) {
            if (i >= 1) {
                first = second;
                second = tSet.pollFirst();
            } else {
                second = tSet.pollFirst();
            }
            primeBetweenTwoNumbers(first, second);
        }
        // 4
        long endTime = System.currentTimeMillis();
        double duration = (endTime - startTime) / 1000.0;

        System.out.println("Total execution time using Java is " + duration + " seconds!");
    }

    // 5
    public static void primeBetweenTwoNumbers(int n1, int n2) {
        int cnt = 0;
        for (int i = n1; i <= n2; i++) {
            if (D[i] == 1) cnt++;
        }
        System.out.println("Number of prime number between " + n1 + ", " + n2 + ": " + cnt);
    }

    // 6
    public static void calculatePrimeNumber() {
        for (int i = 2; i <= lastNum; i++) {
            D[i] = i;
        }

        for (int i = 2; i <= lastNum; i++) {
            if (D[i] != 0) {
                D[i] = 1;
                for (int j = i + i; j <= lastNum; j += i) {
                    D[j] = 0;
                }
            }
            if (D[i] == 0) continue;
        }
    }
}
