package inflearn.array;

import java.util.Scanner;

public class _7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        int score = 0;
        int cont = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 1) {
                cont++;
                score += cont;
            } else {
                cont = 0;
            }
        }
        System.out.println(score);
    }
}
