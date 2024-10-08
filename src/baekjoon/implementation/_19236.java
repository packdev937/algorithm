package baekjoon.implementation;

import java.util.*;
import java.io.*;

class _19236 {
    static class Shark {
        int x, y, direction, accumulatePoint;

        Shark(int x, int y, int dir, int eatSum) {
            this.x = x;
            this.y = y;
            this.direction = dir;
            this.accumulatePoint = eatSum;
        }
    }

    static class Fish {
        int x, y, point, direction;
        boolean isAlive;

        Fish(int x, int y, int id, int dir, boolean isAlive) {
            this.x = x;
            this.y = y;
            this.point = id;
            this.direction = dir;
            this.isAlive = isAlive;
        }
    }

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int maxPoints = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] board = new int[4][4];
        List<Fish> fishes = new ArrayList<>();

        // input
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int id = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                Fish f = new Fish(i, j, id, dir, true);
                fishes.add(f);
                board[i][j] = id;
            }
        }

        // 물고기는 작은 순서부터 이동해야 하기 때문에 미리 정렬해둠
        Collections.sort(fishes, Comparator.comparingInt(f -> f.point));

        // 상어는 (0, 0) 물고기를 먹고 시작하며 위치는 -1 로 표현
        Fish firstFish = fishes.get(board[0][0] - 1);
        Shark shark = new Shark(0, 0, firstFish.direction, firstFish.point);
        firstFish.isAlive = false;
        board[0][0] = -1;

        // solution
        dfs(board, shark, fishes);
        System.out.println(maxPoints);
    }

    static void dfs(int[][] arr, Shark shark, List<Fish> fishes) {
        // 현재까지 먹은 양의 최대값 갱신
        maxPoints = Math.max(maxPoints, shark.accumulatePoint);

        // 현재 물고기 상태 복사
        List<Fish> fishCopies = copyFishes(fishes);
        int[][] arrCopies = copyArr(arr);

        // 모든 물고기 순서대로 이동
        for (Fish fish : fishCopies) {
            if (fish.isAlive) {
                moveFish(fish, arrCopies, fishCopies);
            }
        }

        // 상어 이동
        for (int dist = 1; dist < 4; dist++) {
            int nx = shark.x + dx[shark.direction] * dist;
            int ny = shark.y + dy[shark.direction] * dist;

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && arrCopies[nx][ny] > 0) {
                int[][] newArr = copyArr(arrCopies);
                List<Fish> newFishes = copyFishes(fishCopies);

                // 상어가 물고기를 잡아먹음
                Fish targetFish = newFishes.get(arrCopies[nx][ny] - 1);
                Shark newShark = new Shark(targetFish.x, targetFish.y, targetFish.direction, shark.accumulatePoint
                    + targetFish.point);
                targetFish.isAlive = false;

                // 보드 업데이트
                newArr[shark.x][shark.y] = 0; // 이전 상어 위치 빈 칸
                newArr[targetFish.x][targetFish.y] = -1; // 새로운 상어 위치

                dfs(newArr, newShark, newFishes);
            }
        }
    }

    static void moveFish(Fish fish, int[][] board, List<Fish> fishes) {
        if (!fish.isAlive) return;

        for (int i = 0; i < 8; i++) {
            int newDir = (fish.direction + i) % 8;
            int nx = fish.x + dx[newDir];
            int ny = fish.y + dy[newDir];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && board[nx][ny] != -1) {
                // 물고기 이동
                if (board[nx][ny] == 0) {
                    // 빈칸으로 이동
                    board[fish.x][fish.y] = 0;
                    fish.x = nx;
                    fish.y = ny;
                } else {
                    // 다른 물고기와 위치 교환
                    Fish swapFish = fishes.get(board[nx][ny] - 1);
                    swapFish.x = fish.x;
                    swapFish.y = fish.y;
                    board[fish.x][fish.y] = swapFish.point;

                    fish.x = nx;
                    fish.y = ny;
                }

                board[nx][ny] = fish.point;
                fish.direction = newDir;
                return;
            }
        }
    }

    static int[][] copyArr(int[][] arr) {
        int[][] temp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(arr[i], 0, temp[i], 0, 4);
        }
        return temp;
    }

    static List<Fish> copyFishes(List<Fish> fishes) {
        List<Fish> temp = new ArrayList<>();
        for (Fish f : fishes) {
            temp.add(new Fish(f.x, f.y, f.point, f.direction, f.isAlive));
        }
        return temp;
    }
}
