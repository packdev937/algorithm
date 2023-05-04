package programmers.lv2;

public class k진수에서_소수_개수_구하기 {
    public static int solution(int n, int k) {
        int answer = 0;
        String str = "";
        boolean isPrime = true;

        while (true) {
            String prefix = String.valueOf(n % k);
            str = prefix + str;
            if (n / k < k) {
                str = n / k + str;
                break;
            } else
                n /= k;
        }
        Long N;
        String[] sArr = str.split("0");
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i].equals(""))
                continue;
            isPrime = true;
            N = Long.parseLong(sArr[i]);
            if (N == 1)
                isPrime = false;
            else if (N == 2)
                isPrime = true;
            else {
                for (int j = 2; j < Math.sqrt(N); j++) {
                    if (N % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime)
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(30003003, 10));
    }
}
