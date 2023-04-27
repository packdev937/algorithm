package programmers.lv0;

import java.util.Scanner;

public class 옹알이 {
    public int solution(String[] babbling) {
        String[] list = new String[]{"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < list.length; j++)
                babbling[i].replace(list[j], "@");
            babbling[i] = babbling[i].replace("@", "");
            if (babbling[i].equals(""))
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        옹알이 T = new 옹알이();
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        System.out.println(T.solution(babbling));
    }
}
