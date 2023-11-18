package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _2632 {

    static HashMap<Integer, Integer> aPizzaMap = new HashMap<>();
    static HashMap<Integer, Integer> bPizzaMap = new HashMap<>();
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] aPizza = new int[A];
        int[] bPizza = new int[B];
        for (int i = 0; i < A; i++) {
            aPizza[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < B; i++) {
            bPizza[i] = Integer.parseInt(br.readLine());
        }
        calculatePizzaCombination(aPizza, aPizzaMap);
        calculatePizzaCombination(bPizza, bPizzaMap);

        int answer = aPizzaMap.getOrDefault(size, 0) + bPizzaMap.getOrDefault(size, 0);
        for (int a : aPizzaMap.keySet()) {
            if (bPizzaMap.containsKey(size - a)) {
	answer += aPizzaMap.get(a) * bPizzaMap.get(size - a);
            }
        }
        System.out.println(answer);
    }

    private static void calculatePizzaCombination(int[] pizza, HashMap<Integer, Integer> pizzaMap) {
        int totalSum = 0;
        for (int slice : pizza) {
            totalSum += slice;
        }

        for (int start = 0; start < pizza.length; start++) {
            int sum = 0;
            for (int end = 1; end < pizza.length; end++) {
	sum += pizza[(start + end) % pizza.length];
	if (sum > size) {
	    break;
	}
	pizzaMap.put(sum, pizzaMap.getOrDefault(sum, 0) + 1);
            }
        }
        if (totalSum <= size) {
            pizzaMap.put(totalSum, pizzaMap.getOrDefault(totalSum, 0) + 1);
        }
    }
}
