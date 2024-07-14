package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class _1235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] array = new String[N];

        for (int i = 0; i < N; i++) {
            array[i] = br.readLine();
        }

        BigInteger divider = BigInteger.TEN;

        while (true) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < array.length; i++) {
	BigInteger b = new BigInteger(array[i]);
	set.add(String.valueOf(b.remainder(divider)));
            }
            if(set.size() == N){
	System.out.print(String.valueOf(divider).length() -1);
	return;
            }
            divider = divider.multiply(BigInteger.TEN);
        }
    }

}
