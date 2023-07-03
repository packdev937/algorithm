package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _14714 {
    static int N, A, B, DA, DB;
    static Set<Integer> setA = new HashSet<>();
    static Set<Integer> setB = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        DA = Integer.parseInt(st.nextToken());
        DB = Integer.parseInt(st.nextToken());

        setA.add(A);
        setB.add(B);

        int temp, left, right;
        boolean isA = true;

        for (int i = 1; i <= 1000; i++) {
            if (i == 1000) {
                System.out.println("Evil Galazy");
                break;
            }

            if (isA) {
                Set<Integer> newSet = new HashSet<>();
                for (int num : setA) {
                    left = num - DA < 1 ? num - DA + N : num - DA;
                    right = num + DA > N ? num + DA - N : num + DA;
                    newSet.add(left);
                    newSet.add(right);
                }
                for (int check : newSet) {
                    if (setB.contains(check)) {
                        System.out.println(i);
                        return;
                    }
                }
                setA = newSet;
                isA = false;
            } else {
                Set<Integer> newSet = new HashSet<>();
                for (int num : setB) {
                    left = num - DB < 1 ? num - DB + N : num - DB;
                    right = num + DB > N ? num + DB - N : num + DB;
                    newSet.add(left);
                    newSet.add(right);
                }
                for (int check : newSet) {
                    if (setA.contains(check)) {
                        System.out.println(i);
                        return;
                    }
                }
                setB = newSet;
                isA = true;
            }
        }
    }
}
