package inflearn.sorting_searching;

import java.util.*;

class Point implements Comparable<Point> {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Point o) {
        if (this.x != o.x) {
            return this.x - o.x;
        } else {
            return this.y - o.y;
        }
    }
}

public class _7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Point(x, y));
        }

        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            Point p = list.get(i);
            System.out.println(p.x + " " + p.y);
        }
    }
}
