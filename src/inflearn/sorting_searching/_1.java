package inflearn.sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int min;
        int minIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            min = 999;
            for (int j = i; j < arr.length; j++) {
                if (Integer.parseInt(arr[j]) < min) {
                    min = Integer.parseInt(arr[i]);
                    minIndex = j;
                }
                String temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
