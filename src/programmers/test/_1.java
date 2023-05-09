package programmers.test;

import java.util.HashMap;

public class _1 {
    public static void main(String[] args) {
        String file = "foo010bar020.zip";
        String[] head = file.split("\\d+");
        String[] number = file.split("\\D+");

        for (int i = 0; i < head.length; i++) {
            System.out.println("head " + i + ": " + head[i]);
        }

        for (int i = 0; i < number.length; i++) {
            System.out.println("number " + i + ": " + number[i]);
        }

    }
}
