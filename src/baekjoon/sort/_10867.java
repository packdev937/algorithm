package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _10867 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(inputs[i]));
        }

        // Convert the set to an array and sort it
        int[] result = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(result);

        // Print the sorted array
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}

// HashSet은 순서 보장을 하지 않습니다.
// Arrays.sort(set.stream().mapToInt(Integer::intValue).toArray());
// 따로 빼내어서 그 값을 정렬해야 합니다.