package programmers.lv2;

import java.util.LinkedList;

public class 뉴스_클러스터링 {
    public static int solution(String str1, String str2) {
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();
        int cnt = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length() - 1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);

            if (Character.isLetter(a) && Character.isLetter(b)) {
                String pair = String.valueOf(a) + b;
                list1.add(pair);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);

            if (Character.isLetter(a) && Character.isLetter(b)) {
                String pair = String.valueOf(a) + b;
                list2.add(pair);
            }
        }


        // 문자열의 길이를 토대로 A와 B를 구함 ex) 2면 1개 3이면 2개 4면 3개 .. 10 n개
        int len1 = list1.size();
        int len2 = list2.size();

        for (int i = 0; i < list2.size(); i++) {
            if (list1.remove(list2.get(i))) {
                cnt++;
            }
        }
        double j;
        if(list1.size()==0 && list2.size()==0)
            j = 1.0;
        else j = (double) cnt / (double) (len1 + len2 - cnt);
        return (int) (j * 65536);
    }

    public static void main(String[] args) {
        System.out.println(solution("E=M*C^2", "E=M*C^2"));
    }
}
