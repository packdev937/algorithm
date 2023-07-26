package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _1021 {

    static Deque<Integer> deque = new ArrayDeque<>();
    static boolean[] check;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] target = new int[M];
        check = new boolean[N + 1];

        // Initialization
        for (int i = 0; i < N; i++) {
            deque.add(i + 1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        int current;
        int idx = 0;
        int cnt = 0;
        while (true) {
            if (idx == M) {
                break;
            }
            current = deque.peekFirst();
            if (target[idx] == current) {
                check[deque.pollFirst()] = true;
                idx++;
                continue;
            }
            boolean direction = setDirection(current, target[idx]);
            if (direction) {
                while (true) {
                    int num = deque.pollFirst();
                    if (num == target[idx]) {
                        deque.addFirst(num);
                        break;
                    } else {
                        deque.addLast(num);
                    }
                    cnt++;
                }
            } else if (!direction) {
                while (true) {
                    int num = deque.pollLast();
                    if (num == target[idx]) {
                        deque.addFirst(num);
                        cnt++;
                        break;
                    } else {
                        deque.addFirst(num);
                    }
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static boolean setDirection(int current, int find) {
        int left = 0;
        int right = 0;

        int i = current;
        // right check
        while (true) {
            if (i == find) {
                break;
            }
            if (!check[i]) {
                right++;
            }
            i++;
            if (i == N + 1) {
                i = 0;
            }
        }

        i = current;
        // left check
        while (true) {
            if (i == find) {
                break;
            }
            if (!check[i]) {
                left++;
            }
            i--;
            if (i == 0) {
                i = N;
            }
        }

        return right > left ? false : true;
    }
}
