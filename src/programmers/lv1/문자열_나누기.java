package programmers.lv1;

public class 문자열_나누기 {

    public int solution(String s) {
        int answer = 0;
        int i = 0;

        while (i < s.length()) {
            char refChar = s.charAt(i);
            int refCount = 0;
            int otherCount = 0;

            while (i < s.length()) {
                if (s.charAt(i) == refChar) {
                    refCount++;
                } else {
                    otherCount++;
                }

                if (refCount == otherCount) {
                    break;
                }
                i++;
            }
            answer++;
            i++;
        }

        return answer;
    }

}

