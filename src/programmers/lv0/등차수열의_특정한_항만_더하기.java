package programmers.lv0;

import java.util.Scanner;

public class 등차수열의_특정한_항만_더하기 {

    public static int solution(int a, int d, boolean[] included) {
        int current = a;
        int answer = 0;
        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                answer += current;
            }
            current += d;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int d = sc.nextInt();
        boolean[] booleans = new boolean[]{true, false, false, true, true};

        System.out.print(solution(a, d, booleans));
    }

}
