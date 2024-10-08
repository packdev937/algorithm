package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2503 {

    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String guess = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            calculate(guess, strike, ball);
        }

        System.out.println(answer.size());
    }

    private static void calculate(String guess, int strike, int ball) {
        if (answer.size() == 0) {
            initialize();
        }

        List<String> filteredList = new ArrayList<>();
        for (String number : answer) {
            if (isSatisfied(number, guess, strike, ball)) {
	filteredList.add(number);
            }
        }

        answer = filteredList;
    }

    private static boolean isSatisfied(String number, String guess, int strike, int ball) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == guess.charAt(i)) {
	strikeCount++;
            }
            for (int j = 0; j < number.length(); j++) {
	if (i == j) {
	    continue;
	}
	if (number.charAt(i) == guess.charAt(j)) {
	    ballCount++;
	}
            }
        }

        return strikeCount == strike && ballCount == ball;
    }

    private static void initialize() {
        for (int i = 100; i <= 999; i++) {
            String number = String.valueOf(i);
            if (number.contains("0")) {
	continue;
            }

            if (number.charAt(0) == number.charAt(1) || number.charAt(0) == number.charAt(2)
	|| number.charAt(1) == number.charAt(2)) {
	continue;
            }
            answer.add(number);
        }
    }
}
