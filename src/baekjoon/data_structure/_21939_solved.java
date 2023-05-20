package baekjoon.data_structure;

import java.util.*;

public class _21939_solved {

    public static class Problem implements Comparable<Problem> {
        int idx;
        int level;

        public Problem(int idx, int level) {
            this.idx = idx;
            this.level = level;
        }

        // 난이도 순으로 정렬 -> 문제 번호로 정렬
        public int compareTo(Problem o) {
            if (level - o.level == 0) {
                return idx - o.idx;
            } else {
                return level - o.level;
            }
        }

        public String toString() {
            return "idx: " + idx + " level: " + level;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeSet<Problem> ts = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int nowIdx = sc.nextInt();
            int nowLevel = sc.nextInt();
            ts.add(new Problem(nowIdx, nowLevel));
            map.put(nowIdx, nowLevel);
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String command = sc.next();
            if (command.equals("add")) {
                int nowIdx = sc.nextInt();
                int nowLevel = sc.nextInt();
                ts.add(new Problem(nowIdx, nowLevel));
                map.put(nowIdx, nowLevel);
            } else {
                if (command.equals("recommend")) {
                    int x = sc.nextInt();
                    if (x == 1) {
                        System.out.println(ts.last().idx);
                    } else {
                        System.out.println(ts.first().idx);
                    }
                } else {
                    int nowIdx = sc.nextInt();
                    ts.remove(new Problem(nowIdx, map.get(nowIdx)));
                    map.remove(nowIdx);
                }
            }
        }
    }
}
