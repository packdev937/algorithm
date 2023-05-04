package programmers.lv2;

import java.util.HashMap;

public class 주차_요금_계산 {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String> map = new HashMap<>();
        int[] answer = {};
        for (int i = 0; i < records.length; i++) {
            String[] s = records[i].split(" ");
            String time = s[0];
            String car = s[1];
            String type = s[2];
            if (type.equals("IN")) {
                map.put(car, time);
            }
            if (type.equals("OUT")) {
                String[] timeIN = map.get(car).split(":");
                String[] timeOUT = time.split(":");
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
