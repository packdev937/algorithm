package programmers.lv2;

import java.util.Arrays;

public class 최댓값과_최솟값 {
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        String[] S = s.split(" ");
        int[] arr = new int[S.length];
        for (int i = 0; i < S.length; i++) {
            arr[i] = Integer.parseInt(S[i]);
        }
        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[arr.length - 1]);
    }
}
