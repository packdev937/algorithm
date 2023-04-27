package programmers.lv0;

public class 배열_조각하기 {
    public static int[] solution(int[] arr, int[] query) {
        int[] answer;
        int len = arr.length;
        int lp = 0, rp = arr.length - 1;
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                rp -= (len - query[i] - 1);
                len -= (len - query[i] - 1);
            } else {
                lp += query[i];
                len -= query[i];
            }
        }
        answer = new int[len];

        int idx = 0;
        for (int k = lp; k <= rp; k++) {
            answer[idx++] = arr[k];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answer;
        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};
        answer = solution(arr, query);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
        }
    }
}

//import java.util.*;
//class Solution {
//    public int[] solution(int[] arr, int[] query) {
//        int left = 0;
//        int right = arr.length-1;
//        for(int i=0; i<query.length; i++) {
//            int q = query[i] + left;
//            if(i%2==0) {
//                right = q -1;
//            } else {
//                left = q;
//            }
//        }
//        if(left > right)
//            return new int[]{-1};
//        return Arrays.copyOfRange(arr, left, right+1);
//    }
//}