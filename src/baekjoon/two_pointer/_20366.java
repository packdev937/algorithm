package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _20366 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] snow = new int[N];
        for (int i = 0; i < snow.length; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snow);

        int sum1 = 0, sum2 = 0;
        int ldx = 0, rdx = 0;
        int result = Integer.MAX_VALUE;

        loopOut:
        for (int i = 0; i < snow.length; i++) {
            for (int j = i+1; j < snow.length; j++) {
                sum1 = snow[i] + snow[j];
                ldx = 0;
                rdx = snow.length-1;
                while (ldx < rdx) {
                    if(ldx == i || ldx == j){
                        ldx++;
                        continue;
                    }
                    if(rdx == i || rdx == j){
                        rdx--;
                        continue;
                    }
                    sum2 = snow[ldx] + snow[rdx];
                    result = Math.min(result, Math.abs(sum1 - sum2));
                    if  (sum1 < sum2) {
                        rdx--;
                    } else if (sum1 > sum2) {
                        ldx++;
                    } else {
                        break loopOut;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
