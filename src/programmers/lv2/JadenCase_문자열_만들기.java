package programmers.lv2;

class Solution {
    public String jadenCase(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char c = s.charAt(0);
        String str = s.substring(1, s.length());

        if (Character.isLowerCase(c)) {
            c = (char) (c - 32);
        }
        str = str.toLowerCase();

        return c + str;
    }

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] sArr = s.split(" ", -1); // -1을 추가해 연속된 공백 문자를 처리합니다.

        for (int i = 0; i < sArr.length; i++) {
            answer.append(jadenCase(sArr[i]));
            if (i != sArr.length - 1) {
                answer.append(" ");
            }
        }
        return answer.toString();
    }
}
