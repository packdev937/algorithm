package sort;

import java.util.Arrays;
import java.util.Scanner;

public class _2587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int avg = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            avg += arr[i];
        }

        Arrays.sort(arr);
        System.out.println(avg / 5);
        System.out.println(arr[2]);
    }
}
