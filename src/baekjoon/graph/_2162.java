package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _2162 {

    static int[] parent;
    static ArrayList<Line> lines = new ArrayList<>();
    static HashMap<Integer, Integer> group = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            lines.add(new Line(i, new Point(x1, y1), new Point(x2, y2)));
        }

        for (int i = 0; i < lines.size(); i++) {
            for (int j = i + 1; j < lines.size(); j++) {
	if (isSameGroup(lines.get(i), lines.get(j))) {
	    union(lines.get(i).id, lines.get(j).id);
	}
            }
        }

        // A->B , B->C 일 때 C의 최종 부모는 A가 아니라 B일 수 있음
        // 따라서 parent[i]로 직접 접근하는 것 보단 find()로 접근하는게 좋음
        for (int i = 0; i < parent.length; i++) {
            int root = find(i);
            group.put(root, group.getOrDefault(root, 0) + 1);
        }

        System.out.println(group.size());
        group.keySet().stream()
            .max(Comparator.comparing(group::get))
            .ifPresent(maxKey -> System.out.println(group.get(maxKey)));
    }

    private static boolean onSegment(Point p, Point q, Point r) {
        if (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
            q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y)) {
            return true;
        }
        return false;
    }

    private static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) {
            return 0;
        }
        return (val > 0) ? 1 : 2;
    }

    private static boolean doIntersect(Line l1, Line l2) {
        int o1 = orientation(l1.to, l1.from, l2.to);
        int o2 = orientation(l1.to, l1.from, l2.from);
        int o3 = orientation(l2.to, l2.from, l1.to);
        int o4 = orientation(l2.to, l2.from, l1.from);

        if (o1 != o2 && o3 != o4) {
            return true;
        }

        if (o1 == 0 && onSegment(l1.to, l2.to, l1.from)) {
            return true;
        }
        if (o2 == 0 && onSegment(l1.to, l2.from, l1.from)) {
            return true;
        }
        if (o3 == 0 && onSegment(l2.to, l1.to, l2.from)) {
            return true;
        }
        if (o4 == 0 && onSegment(l2.to, l1.from, l2.from)) {
            return true;
        }

        return false;
    }

    private static boolean isSameGroup(Line line, Line line1) {
        return doIntersect(line, line1);
    }

    static public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static public void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        // 여기가 바뀌었고
        if (x != y) {
            parent[y] = x;
        }
    }

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {

        int id;
        Point to;
        Point from;

        public Line(int id, Point to, Point from) {
            this.id = id;
            this.to = to;
            this.from = from;
        }
    }
}
