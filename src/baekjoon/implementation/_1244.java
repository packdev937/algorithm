package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] switches = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < switches.length; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int students = Integer.parseInt(br.readLine());
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
	if (gender == 1) {
	    int number = Integer.parseInt(st.nextToken());
	    for (int j = number - 1; j < switches.length; j += number) {
	        switches[j] = switches[j] == 0 ? 1 : 0;
	    }
	}
	if (gender == 2) {
	    int center = Integer.parseInt(st.nextToken());
	    isSymmetric(switches, center);
	    switches[center - 1] = switches[center - 1] == 0 ? 1 : 0;
	}
            }
        }

        for (int i = 0; i < switches.length; i++) {
            bw.write(switches[i] + " ");
            if ((i + 1) % 20 == 0) {
	bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void isSymmetric(int[] switches, int center) {
        int left = center - 1;
        int right = center - 1;
        while (left >= 0 && right < switches.length) {
            if (switches[left] != switches[right]) {
	return;
            } else {
	switches[left] = switches[left--] == 0 ? 1 : 0;
	switches[right] = switches[right++] == 0 ? 1 : 0;
            }
        }
    }
}
