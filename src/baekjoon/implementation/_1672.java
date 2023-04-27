package baekjoon.implementation;

import java.util.Scanner;

public class _1672 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        String temp = "";

        int[][] DNA = {{0, 2, 0, 1}, {2, 1, 3, 0}, {0, 3, 2, 1}, {1, 0, 1, 3}};

        for (int i = 0; i < N; i++) {
            switch (str.charAt(i)) {
                case 'A':
                    temp += '0';
                    break;
                case 'G':
                    temp += '1';
                    break;
                case 'C':
                    temp += '2';
                    break;
                case 'T':
                    temp += '3';
                    break;
                default:
                    System.out.println("ERROR");
            }
        }

        for (int i = 0; i < N - 1; i++) {
            int n1 = Character.getNumericValue(temp.charAt(temp.length() - 2));
            int n2 = Character.getNumericValue(temp.charAt(temp.length() - 1));
            temp = temp.substring(0, temp.length() - 2);
            System.out.println(DNA[n1][n2]);
        }
        System.out.println(temp);

        
    }
}

