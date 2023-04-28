package programmers.lv0;

import java.util.HashMap;
import java.util.Arrays;

public class 주사위_게임_3 {
    public static int Solution(int a, int b, int c, int d) {
        int p, q;
        int[] result = {a, b, c, d};
        Arrays.sort(result);

        System.out.println(result[0] + " " + result[1]);
        // 모든 주사위 수가 다 같은 경우 ex) 2 2 2 2
        if (result[0] == result[3]) {
            return result[0] * 1111;
        }
        // 세 주사위가 같고 하나만 다른 경우
        else if (result[0] != result[3] && result[1] == result[2] && (result[0] == result[1] || result[2] == result[3])) {
            if (result[0] == result[1]) {
                p = result[0];
                q = result[3];
            } else {
                p = result[3];
                q = result[0];
            }
            return (int) Math.pow(10 * p + q, 2);
        }
        // 두 주사위가 같은 경우
        else if (result[0] == result[1] && result[2] == result[3]) {
            p = result[0];
            q = result[2];
            return (p + q) * Math.abs(p - q);
        }
        // 두 주사위가 나오고 하나씩 다른 경우 ex) 2 2 5 6, 2 3 3 6, 2 3 6 6
        else if (result[0] == result[1]) {
            return result[2] * result[3];
        } else if (result[1] == result[2]) {
            return result[0] * result[3];
        } else if (result[2] == result[3]) {
            return result[0] * result[1];
        }
        // 다 다를 경우
        else {
            return result[0];
        }

    }

    public static void main(String[] args) {
        System.out.println(Solution(1, 5, 5, 6));
        System.out.println(Solution(1, 3, 6, 6));
    }
}
