package sort;

import java.util.Arrays;
import java.util.Scanner;

public class _2752 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
