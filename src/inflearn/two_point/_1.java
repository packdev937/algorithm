package inflearn.two_point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] arr2 = br.readLine().split(" ");

        String[] arr = new String[N + M];

        int lt = 0, rt = 0;
        for (int i = 0; i < arr.length; i++) {

            if (lt < N && rt < M) {
                if (Integer.parseInt(arr1[lt]) < Integer.parseInt(arr2[rt]))
                    arr[i] = arr1[lt++];
                else
                    arr[i] = arr2[rt++];
            } else {
                if (lt == N)
                    arr[i] = arr2[rt++];
                else arr[i] = arr1[lt++];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

//twq point?