package baekjoon.dynamic_programming;

import java.util.Scanner;

class Count {
    public int cntZero;
    public int cntOne;

    public Count(int cntZero, int cntOne) {
        this.cntZero = cntZero;
        this.cntOne = cntOne;
    }

    public int getCntOne() {
        return cntOne;
    }

    public int getCntZero() {
        return cntZero;
    }
}

public class _1003 {
    static Count[] p = new Count[100000];

    public Count fibo(int n) {
        if (p[n] != null) return p[n];
        if (n == 0) {
            return p[0];
        } else if (n == 1) {
            return p[1];
        } else
            return p[n] = new Count(fibo(n - 1).getCntZero() + fibo(n - 2).cntZero, fibo(n - 1).getCntOne() + fibo(n - 2).getCntOne());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        _1003 T = new _1003();
        p[0] = new Count(1, 0);
        p[1] = new Count(0, 1);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int t = sc.nextInt();
            T.fibo(t);
            System.out.println(p[t].getCntZero() + " " + p[t].getCntOne());
        }
    }
}
