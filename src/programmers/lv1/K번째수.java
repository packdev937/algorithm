package programmers.lv1;

import java.util.ArrayList;
import java.util.Collections;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> list;
        for (int l = 0; l < answer.length; l++) {
            list = new ArrayList<>();
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];

            for (int m = i - 1; m < j; m++) {
                list.add(array[m]);
            }
            Collections.sort(list);
            answer[l] = list.get(k - 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        K번째수 T = new K번째수();
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = T.solution(array, commands);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);

        }
    }
}
