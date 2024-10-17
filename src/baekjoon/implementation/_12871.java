package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        int sLength = s.length();
        int tLength = t.length();

        int lcmLength = lcm(sLength, tLength);

        String repeatedS = repeatString(s, lcmLength / sLength);
        String repeatedT = repeatString(t, lcmLength / tLength);

        System.out.println(repeatedS.equals(repeatedT) ? 1 : 0);
    }

    // 주어진 문자열을 n번 반복하여 생성하는 메소드
    private static String repeatString(String str, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
