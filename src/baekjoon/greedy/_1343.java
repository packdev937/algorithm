package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().replaceAll("XXXX", "AAAA").replaceAll("XX", "BB");
        System.out.println(input.contains("X") ? -1 : input);
    }
}
