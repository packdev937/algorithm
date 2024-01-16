package baekjoon.divide_and_conquer;

import java.io.*;
import java.util.StringTokenizer;

public class _1517 {

    static long answer;
    static long[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new long[N];
        B = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        divide_conquer(0, N - 1);
        System.out.println(answer);
    }

    static void divide_conquer(int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            divide_conquer(low, mid);
            divide_conquer(mid + 1, high);
            merge(low, mid, high);
        }
    }

    static void merge(int low, int mid, int high) {
        int leftIndex = low;
        int rightIndex = mid + 1;
        int index = low;

        while (leftIndex <= mid && rightIndex <= high) {
            if (A[leftIndex] <= A[rightIndex]) {
	B[index] = A[leftIndex];
	leftIndex++;
            } else {
	B[index] = A[rightIndex];
	rightIndex++;
	answer += (mid + 1 - leftIndex);
            }
            index++;
        }

        while (leftIndex <= mid) {
            B[index] = A[leftIndex];
            leftIndex++;
            index++;
        }

        while (rightIndex <= high) {
            B[index] = A[rightIndex];
            rightIndex++;
            index++;
        }

        for (int i = low; i < high + 1; i++) {
            A[i] = B[i];
        }

    }

}

