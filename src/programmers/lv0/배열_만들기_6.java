package programmers.lv0;

import java.util.ArrayList;

public class 배열_만들기_6 {
    public static int[] Solution(int[] arr) {
        ArrayList<Integer> stk = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (stk.size() == 0) {
                stk.add(arr[i]);
            } else {
                if (stk.get(stk.size() - 1) == arr[i]) {
                    stk.remove(stk.size() - 1);
                } else if (stk.get(stk.size() - 1) != arr[i]) {
                    stk.add(arr[i]);
                }
            }
        }

        int idx = 0;
        int[] answer = new int[stk.size()];
        for (int i : stk) {
            answer[idx++] = i;
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] answer = Solution(new int [] {0, 1, 1, 1, 0});
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
