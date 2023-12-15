package baekjoon.data_structure;

import java.util.Scanner;

public class _4299 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = sc.nextInt();
        int diff = sc.nextInt();

        int teamA = (sum + diff) / 2;
        int teamB = (sum - diff) / 2;

        if (teamA < 0 || teamB < 0 || teamA + teamB != sum) {
            System.out.println(-1);
        } else {
            System.out.println(teamA + " " + teamB);
        }

        sc.close();
    }
}

