package baekjoon.implementation;

import java.util.Scanner;

public class _1475 {

    static int[] num = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '6' || number.charAt(i) == '9') {
                if (num[6] > num[9]) {
                    num[9]++;
                    continue;
                } else {
                    num[6]++;
                    continue;
                }
            }
            num[Character.getNumericValue(number.charAt(i))]++;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            max = Math.max(max, num[i]);
        }
        System.out.println(max);
    }

}
