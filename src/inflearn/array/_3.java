package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            System.out.println(RPC(A[i], B[i]));
        }
    }

    public static char RPC(String a, String b) {
        if (a.equals(b))
            return 'D';
        else {
            switch (a) {
                case "1":
                    if (b.equals("2"))
                        return 'B';
                    else return 'A';
                case "2":
                    if (b.equals("1"))
                        return 'A';
                    else return 'B';
                case "3":
                    if (b.equals("2"))
                        return 'A';
                    else return 'B';
            }
        }
        return 'F';
    }
}
