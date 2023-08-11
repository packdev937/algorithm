package programmers.lv1;

public class 공원_산책 {

    public static int[] solution(String[] park, String[] routes) {
        // 시작 좌표 구하기
        int sx = 0, sy = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }

        // 현재 위치를 담는 변수
        int cx = sx, cy = sy;
        for (int i = 0; i < routes.length; i++) {
            String[] s = routes[i].split(" ");
            int dist = Integer.parseInt(s[1]);
            switch (s[0]) {
                case "E":
                    if (cy + dist >= park[0].length()) {
                        break;
                    } else if (park[cx].substring(cy, cy + dist + 1).contains("X")) {
                        break;
                    } else {
                        cy = cy + dist;
                        break;
                    }
                case "N":
                    if (cx - dist < 0) {
                        break;
                    } else {
                        boolean isX = false;
                        for (int k = cx; k >= cx - dist; k--) {
                            if (park[k].charAt(cy) == 'X') {
                                isX = true;
                                break;
                            }
                        }
                        if (isX) {
                            break;
                        } else {
                            cx -= dist;
                            break;
                        }
                    }
                case "S":
                    if (cx + dist >= park.length) {
                        break;
                    } else {
                        boolean isX = false;
                        for (int k = cx; k < cx + dist + 1; k++) {
                            if (park[k].charAt(cy) == 'X') {
                                isX = true;
                                break;
                            }
                        }
                        if (isX) {
                            break;
                        } else {
                            cx += dist;
                            break;
                        }
                    }
                case "W":
                    if (cy - dist < 0) {
                        break;
                    } else if (park[cx].substring(cy - dist, cy + 1).contains("X")) {
                        break;
                    } else {
                        cy = cy - dist;
                        break;
                    }
                default:
                    break;
            }
        }
        return new int[]{cx, cy};
    }

    public static void main(String[] args) {
        int [] answer = solution(new String[]{"SOO","OOO","OOO"}, new String[]{"E 2", "S 2", "W 1"});
        System.out.print(answer[0]+" "+answer[1]);
    }
}