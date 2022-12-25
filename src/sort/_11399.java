package sort;

import java.util.Arrays;
import java.util.Scanner;

public class _11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                total += arr[j];
            }
        }
        System.out.println(total);
    }
}
