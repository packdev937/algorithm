package programmers.lv2;

public class 타겟_넘버 {
    static int cnt = 0;

    public static void dfs(int numbers[], int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                cnt++;
                return;
            } else
                return;
        } else {
            dfs(numbers, target, index + 1, sum + numbers[index]);
            dfs(numbers, target, index + 1, sum - numbers[index]);
        }
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        int answer = cnt;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,1,2,1}, 4));
    }
}
