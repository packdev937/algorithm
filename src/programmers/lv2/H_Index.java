package programmers.lv2;

import java.util.Arrays;

public class H_Index {
    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int n = citations.length;
        for(int i = 0; i<citations.length; i++){
            if(citations[i] >= citations.length-i){
                answer = citations.length-i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int []{1,2,3,4,5,6,7,8,9}));
    }
}
