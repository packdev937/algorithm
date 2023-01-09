package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Character.getNumericValue(br.readLine().charAt(0));
        String[] arr = br.readLine().split(" ");
        int max = 0;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (Integer.parseInt(arr[i]) > max) {
                cnt++;
                max = Integer.parseInt(arr[i]);
            } else continue;
        }
        System.out.println(cnt);
    }
}
