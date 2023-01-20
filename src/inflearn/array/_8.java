package inflearn.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class _8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        Integer[] ori = new Integer[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            ori[i] = arr[i];
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int rank = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                map.put(arr[i], rank);
            } else {
                rank = i+1;
                map.put(arr[i], i + 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(map.get(ori[i]) + " ");
        }
    }
}

// 5개를 입력받는다
// 정렬한 뒤 숫자를 부여한다?