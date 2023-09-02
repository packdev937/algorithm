package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _22866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> lStack = new Stack<>();
        Stack<Integer> rStack = new Stack<>();

        int[] leftBuildingCounts = new int[N];
        int[] rightBuildingCounts = new int[N];
        int[] nearestBuilding = new int[N];

        for (int i = 0; i < N; i++) {
            while (!lStack.isEmpty() && arr[lStack.peek()] <= arr[i]) {
                lStack.pop();
            }
            leftBuildingCounts[i] = lStack.size();
            if (!lStack.isEmpty()) {
                nearestBuilding[i] = lStack.peek() + 1;
            }
            lStack.push(i);
        }

        for (int i = N - 1; i >= 0; i--) {
            while (!rStack.isEmpty() && arr[rStack.peek()] <= arr[i]) {
                rStack.pop();
            }
            rightBuildingCounts[i] = rStack.size();
            if (!rStack.isEmpty() && (nearestBuilding[i] == 0
                || Math.abs(nearestBuilding[i] - i - 1) > Math.abs(rStack.peek() - i))) {
                nearestBuilding[i] = rStack.peek() + 1;
            }
            rStack.push(i);
        }

        for (int i = 0; i < N; i++) {
            if (leftBuildingCounts[i] + rightBuildingCounts[i] == 0) {
                bw.write("0\n");
            } else {
                bw.write((leftBuildingCounts[i] + rightBuildingCounts[i]) + " " + nearestBuilding[i]
                    + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
