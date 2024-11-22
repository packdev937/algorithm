package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10801 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aCount = 0;
        int bCount = 0;

        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        for (int i = 0; i < a.length; i++) {
            if (Integer.parseInt(a[i]) > Integer.parseInt(b[i])) {
	aCount++;
            } else if (Integer.parseInt(a[i]) < Integer.parseInt(b[i])) {
	bCount++;
            }
        }

        if (aCount == bCount) {
            System.out.println("D");
        } else {
            String answer = aCount > bCount ? "A" : "B";
            System.out.print(answer);
        }
        return;
    }
}
