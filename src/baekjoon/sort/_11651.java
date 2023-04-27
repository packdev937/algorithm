package baekjoon.sort;

import java.util.Scanner;
import java.util.TreeSet;

class Point2 implements Comparable<Point2> {
    int x, y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point2 o) {
        if (this.y == o.y)
            return this.x - o.x;
        else return this.y - o.y;
    }
}

public class _11651 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        TreeSet<Point2> tSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            tSet.add(new Point2(sc.nextInt(), sc.nextInt()));
        }

        for (int i = 0; i < N; i++) {
            Point2 temp = tSet.pollFirst();
            System.out.println(temp.x + " " + temp.y);
        }

    }
}
