package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        String[] sArr;

        // 초기 값 세팅
        int cnt = 0;
        deque.add(0);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            sArr = br.readLine().split(" ");
            int temp = Integer.parseInt(sArr[1]);
            if (deque.peekLast() < temp) {
                deque.add(temp);
                cnt++;
            } else {
                while (deque.peekLast() > temp) {
                    deque.pollLast();
                }
                if (deque.peekLast() != temp) {
                    cnt++;
                    deque.add(temp);
                }
            }
        }

        System.out.println(cnt);
    }
}
