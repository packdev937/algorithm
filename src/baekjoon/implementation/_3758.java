package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _3758 {

    static class Team implements Comparable<Team> {

        int id;
        int[] problems;
        int count;
        int lastSubmitTime;

        public Team(int id, int problemCount, int count, int lastSubmitTime) {
            this.id = id;
            this.problems = new int[problemCount];
            this.count = count;
            this.lastSubmitTime = lastSubmitTime;
        }

        public int getScore() {
            int score = 0;
            for (int i = 0; i < problems.length; i++) {
	score += problems[i];
            }
            return score;
        }

        public void increaseCount() {
            count++;
        }

        public void solve(int problemId, int score) {
            if (problems[problemId] < score) {
	problems[problemId] = score;
            }
        }

        @Override
        public int compareTo(Team o) {
            if (this.getScore() == o.getScore()) {
	if (this.count == o.count) {
	    return this.lastSubmitTime - o.lastSubmitTime;
	} else {
	    return this.count - o.count;
	}
            } else {
	return o.getScore() - this.getScore();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            // 팀의 개수
            int n = Integer.parseInt(input[0]);

            // 문제의 개수
            int k = Integer.parseInt(input[1]);

            // 팀 id
            int t = Integer.parseInt(input[2]);

            //로그 엔트리 개수
            int m = Integer.parseInt(input[3]);

            Team[] teams = new Team[n];
            for (int j = 0; j < n; j++) {
	teams[j] = new Team(j, k, 0, 0);
            }

            for (int j = 0; j < m; j++) {
	String[] log = br.readLine().split(" ");
	int teamId = Integer.parseInt(log[0])-1;
	int problemId = Integer.parseInt(log[1])-1;
	int score = Integer.parseInt(log[2]);

	teams[teamId].increaseCount();
	teams[teamId].lastSubmitTime = j;
	teams[teamId].solve(problemId, score);
            }

            Arrays.sort(teams);
            for (int j = 0; j < n; j++) {
	if (teams[j].id == t - 1) {
	    System.out.println(j + 1);
	    break;
	}
            }
        }
    }
}
