package programmers.lv2;

public class 다음_큰_숫자 {
    public int countOnes(String b) {
        int cnt = 0;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '1')
                cnt++;
        }
        return cnt;
    }

    public int solution(int n) {
        String b = Integer.toBinaryString(n);
        int nextNum = n+1;

        while (countOnes(Integer.toBinaryString(nextNum)) != countOnes(b)) {
            nextNum++;
        }

        return nextNum;
    }

    public static void main(String[] args) {
        다음_큰_숫자 T = new 다음_큰_숫자();
        System.out.println(T.solution(15));
    }

}
