package inflearn.sorting_searching;

import java.util.Scanner;

public class _5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] unique = new int[100000];
        boolean isUnique = true;
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (unique[temp] == 1) {
                isUnique = false;
                break;
            } else {
                unique[temp]++;
            }
        }
        if (isUnique)
            System.out.print("U");
        else System.out.print("D");
    }
}
