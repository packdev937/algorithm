package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class _5568 {

    static TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        boolean[] ch = new boolean[N];
        backtracking(arr, ch, "", K, 0);
        System.out.println(set.size());
    }

    public static void backtracking(String[] arr, boolean[] ch, String str, int K, int lv) {
        if (lv == K) {
            set.add(Integer.parseInt(str));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!ch[i]) {
	String temp = str;
	str += arr[i];
	ch[i] = true;
	backtracking(arr, ch, str, K, lv + 1);
	ch[i] = false;
	str = temp;
            }
        }
    }
}
