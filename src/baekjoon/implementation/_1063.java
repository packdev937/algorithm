package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1063 {

    static int ky = 0;
    static int kx = 0;
    static int sy = 0;
    static int sx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        int[] kingPoint = getPoint(king);
        ky = kingPoint[1];
        kx = kingPoint[0];

        String stone = st.nextToken();
        int[] stonePoint = getPoint(stone);
        sy = stonePoint[1];
        sx = stonePoint[0];

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            move(command);
        }

        System.out.println(transferPoint(ky, kx));
        System.out.println(transferPoint(sy, sx));
    }

    private static int[] getPoint(String target) {
        int[] point = new int[2];
        point[0] = target.charAt(0) - 'A';
        point[1] = target.charAt(1) - '1';
        return point;
    }

    private static String transferPoint(int y, int x) {
        return (char) (x + 'A') + "" + (y + 1);
    }

    private static void move(String command) {
        int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
        int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};

        int direction = 0;

        switch (command) {
            case "R":
	direction = 0;
	break;
            case "L":
	direction = 1;
	break;
            case "B":
	direction = 2;
	break;
            case "T":
	direction = 3;
	break;
            case "RT":
	direction = 4;
	break;
            case "LT":
	direction = 5;
	break;
            case "RB":
	direction = 6;
	break;
            case "LB":
	direction = 7;
	break;
        }

        int newKy = ky + dy[direction];
        int newKx = kx + dx[direction];

        if (newKy < 0 || newKx < 0 || newKy >= 8 || newKx >= 8) {
            return;
        }

        if(newKx == sx && newKy == sy) {
            int newSy = sy + dy[direction];
            int newSx = sx + dx[direction];

            if (newSy < 0 || newSx < 0 || newSy >= 8 || newSx >= 8) {
	return;
            }
            sy = newSy;
            sx = newSx;
        }

        ky = newKy;
        kx = newKx;

    }
}