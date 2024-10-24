package baekjoon.implementation;

import java.util.Scanner;

public class _2877 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        K++;

        StringBuilder binaryRepresentation = new StringBuilder();

        while (K > 0) {
            binaryRepresentation.append(K % 2);
            K /= 2;
        }

        StringBuilder result = new StringBuilder();

        for (int i = binaryRepresentation.length() - 2; i >= 0; i--) {
            if (binaryRepresentation.charAt(i) == '0') {
	result.append(4);
            } else {
	result.append(7);
            }
        }

        System.out.println(result);
    }
}