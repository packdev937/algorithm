package programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class 문자열_내림차순으로_배치하기 {

    public static void main(String[] args) {
        String s = "Zbcdefg";

        // version 1
//        Character[] arr = new Character[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            arr[i] = s.charAt(i);
//        }
//
//        Arrays.sort(arr, new Comparator<Character>() {
//            @Override
//            public int compare(Character o1, Character o2) {
//                return Character.compare(o2, o1);
//            }
//        });
//
//        Arrays.asList(arr).forEach((c) -> System.out.print(c));
//
        // version 2
        StringBuilder sb = new StringBuilder();
        Character[] arr = s.chars()
            .mapToObj(c -> (char) c)
            .sorted(Comparator.reverseOrder())
            .toArray(Character[]::new);

        for(char c : arr) {
            sb.append(c);
        }

        System.out.print(sb);
    }
}
