package programmers.lv0;

public class 평행 {
    public int solution(int[][] dots) {
        int answer = 0;
        loop:
        for (int i = 0; i < dots.length; i++) {
            for (int j = 0; j < dots.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < dots.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    for (int l = 0; l < dots.length; l++) {
                        if (l == i || l == j || l == k) {
                            continue;
                        }
                        double slope1, slope2;

                        slope1 = (dots[i][1] - dots[j][1]) / (dots[i][0] - dots[j][0]);
                        slope2 = (dots[k][1] - dots[l][1]) / (dots[k][0] - dots[l][0]);

                        if (slope1 == slope2 && slope1 != 0) {
                            answer = 1;
                            break loop;
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        평행 T = new 평행();
        int[][] dots = {{3, 5}, {4, 1}, {3, 5}, {4, 1}};
        System.out.println(T.solution(dots));
    }
}
