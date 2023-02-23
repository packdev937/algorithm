package inflearn.sorting_searching;

import java.util.Scanner;

public class _6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int taller = 999;
        int shorter = 999;
        for (int i = arr.length-1; i >= 0; i--) {
            if(shorter == 999){
                if(arr[i] < arr[i-1]){
                    shorter = i;
                }
            }else{
                if(arr[i]>=arr[shorter-1]){
                    taller = i;
                }
            }
        }
        System.out.print((taller+1) + " " + (shorter+1));
    }
}
