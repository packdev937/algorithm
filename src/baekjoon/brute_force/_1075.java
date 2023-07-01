package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int F = Integer.parseInt(br.readLine());

        while (true) {
            String temp = N.substring(0, N.length() - 2);
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    String add = String.valueOf(i)+String.valueOf(j);
                    if(Integer.parseInt(temp+add)%F == 0){
                        System.out.println(add);
                        return;
                    }
                }
            }
        }
    }
}
