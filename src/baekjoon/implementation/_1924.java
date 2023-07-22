package baekjoon.implementation;

import java.util.Scanner;

public class _1924 {

    static int[] arr = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int D = sc.nextInt();

        int dayoff = 0;
        for (int i = 1; i < M; i++) {
            dayoff += arr[i - 1];
        }
        dayoff += D;


        switch (dayoff % 7) {
            case 0:
                System.out.print("SUN");
                break;
            case 1:
                System.out.print("MON");
                break;
            case 2:
                System.out.print("TUE");
                break;
            case 3:
                System.out.print("WED");
                break;
            case 4:
                System.out.print("THU");
                break;
            case 5:
                System.out.print("FRI");
                break;
            case 6:
                System.out.print("SAT");
                break;
        }
    }
}
