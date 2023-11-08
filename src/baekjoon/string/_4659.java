package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            if (isAcceptable(input)) {
                System.out.printf("<%s> is acceptable.\n", input);
                continue;
            }
            System.out.printf("<%s> is not acceptable.\n", input);
        }
    }

    public static boolean isAcceptable(String input) {
        boolean isVowel = false;
        char previous = input.charAt(0);
        int vCnt = 0;
        int cCnt = 0;
        if (isVowel(previous)) {
            vCnt++;
            isVowel = true;
        } else {
            cCnt++;
        }
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == previous) {
                if ("eo".indexOf(input.charAt(i)) != -1) {
                    vCnt++;
                    continue;
                }
                return false;
            }
            if (isVowel(input.charAt(i))) {
                vCnt++;
                isVowel = true;
                cCnt = 0;
            } else {
                cCnt++;
                vCnt = 0;
            }
            if (vCnt == 3 || cCnt == 3) {
                return false;
            }
            previous = input.charAt(i);
        }
        if (!isVowel) {
            return false;
        }
        return true;
    }

    public static boolean isVowel(Character c) {
        if ("aeiou".indexOf(c) != -1) {
            return true;
        }
        return false;
    }

}
