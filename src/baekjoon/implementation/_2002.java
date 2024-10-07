package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _2002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> carInOrder = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String car = br.readLine();
            carInOrder.put(car, i);
        }

        int[] exitOrder = new int[N];
        for (int i = 0; i < N; i++) {
            String car = br.readLine();
            exitOrder[i] = carInOrder.get(car);
        }

        int answer = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
	if (exitOrder[i] > exitOrder[j]) {
	    answer++;
	    break;
	}
            }
        }

        System.out.println(answer);
    }
}
