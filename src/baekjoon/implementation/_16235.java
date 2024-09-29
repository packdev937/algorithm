package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class _16235 {

    private static class Tree implements Comparable<Tree> {

        int x, y, age;

        public Tree(int x, int y, int age) {
            super();
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] A = new int[N + 1][N + 1];
        int[][] energy = new int[N + 1][N + 1]; // 양분

        Deque<Tree> trees = new LinkedList<>();

        // A[r][c] 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
	A[i][j] = Integer.parseInt(st.nextToken());
	energy[i][j] = 5;
            }
        }

        // 나무 리스트에 추가
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int tree_age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, tree_age));
        }

        while (K > 0) {
            Queue<Tree> deadTrees = new LinkedList<>();

            // 봄
            spring(trees, energy, deadTrees);

            // 여름
            summer(deadTrees, energy);

            // 가을
            fall(trees, N);

            // 겨울
            winter(N, energy, A);

            K--;
        }

        bw.write(trees.size() + "\n");
        bw.flush();
        bw.close();
    }

    private static void winter(int N, int[][] energy, int[][] A) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
	energy[i][j] += A[i][j];
            }
        }
    }

    private static void fall(Deque<Tree> trees, int N) {
        Queue<Tree> temp_list = new LinkedList<>();
        for (Tree t : trees) {
            if (t.age % 5 == 0) {
	temp_list.add(t);
            }
        }
        while (!temp_list.isEmpty()) {
            Tree t = temp_list.poll();

            for (int i = 0; i < 8; i++) {
	int next_x = t.x + dx[i];
	int next_y = t.y + dy[i];
	if (next_x >= 1 && next_x <= N && next_y >= 1 && next_y <= N) {
	    trees.addFirst(new Tree(next_x, next_y, 1));
	}
            }
        }
    }

    private static void summer(Queue<Tree> deadTrees, int[][] energy) {
        for (Tree t : deadTrees) {
            energy[t.x][t.y] += t.age / 2;
        }
    }

    private static void spring(Deque<Tree> trees, int[][] energy, Queue<Tree> deadTrees) {
        for (int i = 0; i < trees.size(); ) {
            Tree cur = trees.poll();
            if (energy[cur.x][cur.y] >= cur.age) {
	energy[cur.x][cur.y] -= cur.age;
	cur.age++;
	i++;
	trees.add(cur);
            } else {
	deadTrees.add(cur);
            }
        }
    }
}
