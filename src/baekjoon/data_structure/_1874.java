package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class _1874 {
    static Deque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        // Stack Initialization
        int idx = 1;
        boolean isFalse = false;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(stack.isEmpty()){
                stack.push(idx++);
                sb.append("+").append("\n");
            }
            while(stack.peek() != arr[i]){
                stack.push(idx++);
                sb.append("+").append("\n");
                if(idx > N+1)
                    break;
            }
            if (stack.peek() == arr[i]) {
                stack.pop();
                sb.append("-").append("\n");
            }
            if (idx > N + 1) {
                isFalse = true;
                break;
            }
        }

        if (isFalse)
            System.out.println("NO");
        else System.out.println(sb);

//        int idx = 1;
//        boolean isFalse = false;
//        for (int i = 0; i < arr.length; i++) {
//            if (stack.isEmpty()) {
//                stack.push(idx++);
//                sb.append("+").append("\n");
//            }
//            while (stack.peek() != arr[i]) {
//                stack.push(idx++);
//                sb.append("+").append("\n");
//            }
//            if (stack.peek() == arr[i]) {
//                stack.pop();
//                sb.append("-").append("\n");
//            }
//
//            if (idx > N + 1) {
//                isFalse = true;
//                break;
//            }
//        }
//        if (isFalse)
//            System.out.println("NO");
//        else System.out.println(sb);
    }
}
