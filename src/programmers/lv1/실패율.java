package programmers.lv1;

import java.util.*;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> rank = new HashMap<>();
        int[] answer = new int[N];
        int userNum = stages.length;
        int[] userArrived = new int[N + 1];
        double[] failedRate = new double[N];

        double rate;

        for (int i = 0; i < stages.length; i++) {
            int s = stages[i];
            for (int j = 0; j < s; j++) {
                userArrived[j]++;
            }
        }

        for (int i = 0; i < stages.length; i++) {
            if (stages[i] == N + 1)
                continue;
            failedRate[stages[i] - 1] += (double) 1 / userArrived[stages[i] - 1];
        }
        for (int i = 0; i < failedRate.length; i++) {
            System.out.println(failedRate[i]);
        }

//        for (Double key : rank.keySet()){
//            System.out.println(rank.get(key)+"@@");
//        }

        Object[] mapKey = rank.keySet().toArray();
        Arrays.sort(mapKey);

        int idx = 0;

        return answer;
    }

    public static void main(String[] args) {
        실패율 T = new 실패율();
        int[] stages = new int[]{2,1,2,6,2,4,3,3};
        int[] answer = T.solution(5, stages);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
