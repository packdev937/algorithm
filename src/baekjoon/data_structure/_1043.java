package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _1043 {

    public static int[] parent;
    public static boolean[] truth;
    public static ArrayList<ArrayList<Integer>> party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        // 사람 N, 파티의 수 M
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        // 진실을 알고 있는 사람을 판별하기 위한 배열
        truth = new boolean[N + 1];
        parent = new int[N + 1];

        // parent 함수 Initialization
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        party = new ArrayList<>();

        // 진실을 알고 있는 수를 입력 받음
        s = br.readLine().split(" ");
        int T = Integer.parseInt(s[0]);

        // 만약 0이 아니라면
        if (T != 0) {
            for (int i = 0; i < T; i++) {
                truth[Integer.parseInt(s[i + 1])] = true;
            }
        }

        for (int i = 0; i < M; i++) {
            party.add(new ArrayList<>());
        }

        // 파티 정보를 ArrayList에 저장

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                party.get(i).add(Integer.parseInt(s[j]));
            }
        }

        for (int k = 0; k < M; k++) {
            for (int i = 0; i < M; i++) {
                int P = party.get(i).get(0);
                boolean isTruth = false;
                int temp = 0;

                for (int j = 0; j < P; j++) {
                    if (truth[parent[party.get(i).get(j + 1)]]) {
                        isTruth = true;
                        temp = party.get(i).get(j + 1);
                        break;
                    }
                }

                if (isTruth) {
                    for (int j = 0; j < P; j++) {
                        union(temp, party.get(i).get(j + 1));
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int P = party.get(i).get(0);
            boolean isAble = false;
            for (int j = 0; j < P; j++) {
                if (truth[parent[party.get(i).get(j + 1)]]) {
                    isAble = true;
                    break;
                }
            }
            if (!isAble)
                cnt++;
        }
        System.out.println(cnt);
    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (truth[x])
            parent[y] = x;
        else parent[x] = y;
    }
}

