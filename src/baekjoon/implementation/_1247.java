package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class _1247 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger[] bigIntegers = new BigInteger[100000];
            bigIntegers[0] = new BigInteger("0");
            for (int j = 1; j < N + 1; j++) {
                bigIntegers[i] = new BigInteger(br.readLine());
                bigIntegers[0] = bigIntegers[0].add(bigIntegers[i]);
            }
            if (bigIntegers[0].compareTo(BigInteger.ZERO) == 0) {
                System.out.println(0);
            } else if (bigIntegers[0].compareTo(BigInteger.ZERO) == 1) {
                System.out.println("+");
            } else if (bigIntegers[0].compareTo(BigInteger.ZERO) == -1) {
                System.out.println("-");
            }
        }
    }
}
