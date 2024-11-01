package programmers.lv1;

public class 소수_만들기 {
    boolean[] primes = new boolean[10000001];
    int answer = 0;

    public int solution(int[] nums) {
        calculatePrimeNumber();
        calculate(0, 0, nums, 0);
        return answer;
    }

    // 조합을 선택하는 메서드 수정
    private void calculate(int index, int total, int[] nums, int depth) {
        if (depth == 3) { // 정확히 3개의 숫자를 선택한 경우
            if (!primes[total]) { // 합계가 소수이면
	answer++;
            }
            return; // 종료 조건
        }

        for (int i = index; i < nums.length; i++) {
            calculate(i + 1, total + nums[i], nums, depth + 1); // 숫자를 선택하고 재귀 호출
        }
    }

    // 에라토스테네스의 체로 소수 계산
    private void calculatePrimeNumber() {
        primes[0] = true; // 0은 소수가 아님
        primes[1] = true; // 1은 소수가 아님
        for (int i = 2; i * i < primes.length; i++) {
            if (!primes[i]) { // i가 소수인 경우
	for (int j = i * i; j < primes.length; j += i) {
	    primes[j] = true; // 소수가 아닌 숫자 표시
	}
            }
        }
    }

}
