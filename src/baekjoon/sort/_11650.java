package baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point> {
    int x, y;

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x)
            return this.y - o.y;
        else return this.x - o.x;
    }
}

public class _11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Point[] arr = new Point[N];

        for (int i = 0; i < arr.length; i++) {
            // 주의 객체 배열을 생성할 때에는 인덱스에 접근할 때 마다 객체 생성자를 생성하자
            arr[i] = new Point();
            arr[i].x = sc.nextInt();
            arr[i].y = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].x + " " + arr[i].y);
        }
    }
}
