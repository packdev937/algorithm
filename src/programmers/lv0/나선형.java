package programmers.lv0;

public class 나선형 {
    public static void main(String[] args) {
        int[][] answer = solution(5);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int lp = 0, rp = 0, type = 0;
        for (int i = 0; i < n * n; i++) {
            switch (type) {
                case 0:
                    if (rp < n && answer[lp][rp] == 0) {
                        answer[lp][rp++] = i + 1;
                    } else {
                        rp--;
                        lp++;
                        i--;
                        type = 1;
                    }
                    break;
                case 1:
                    if (lp < n && answer[lp][rp] == 0) {
                        answer[lp++][rp] = i + 1;
                    } else {
                        lp--;
                        rp--;
                        i--;
                        type = 2;
                    }
                    break;
                case 2:
                    if (rp >= 0 && answer[lp][rp] == 0) {
                        answer[lp][rp--] = i + 1;
                    } else {
                        rp++;
                        lp--;
                        i--;
                        type = 3;
                    }
                    break;
                case 3:
                    if (lp >= 0 && answer[lp][rp] == 0) {
                        answer[lp--][rp] = i + 1;
                    } else {
                        lp++;
                        rp++;
                        i--;
                        type = 0;
                    }
                    break;
            }
        }
        return answer;
    }
}

