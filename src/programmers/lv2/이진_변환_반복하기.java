package programmers.lv2;

public class 이진_변환_반복하기 {
    public static int[] solution(String s) {
        int cnt=0, cntZero = 0;
        while (true) {
            cnt++;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0')
                    cntZero++;
            }
            s = s.replaceAll("0", "");
            s = Integer.toBinaryString(s.length());
            if (s.equals("1"))
                break;
        }
        int[] answer = {cnt, cntZero};
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("1111111")[0]);
    }
}
