package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _27964 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> cheese = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            if (input[i].endsWith("Cheese")) {
	cheese.put(input[i], cheese.getOrDefault(input[i], 0) + 1);
            }
        }

        if (cheese.size() >= 4) {
            System.out.print("yummy");
            return;
        }
        System.out.print("sad");
    }

}

// 서로 다른 네 종류의 치즈
