package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        String[] str_numbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str_numbers[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(str_numbers, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        if (str_numbers[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : str_numbers) {
            sb.append(str);
        }

        return sb.toString();
    }
}