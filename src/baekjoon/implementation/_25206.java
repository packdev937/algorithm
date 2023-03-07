package baekjoon.implementation;

import java.util.Scanner;

public class _25206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalMajor = 0;
        double totalGrade = 0;

        for (int i = 0; i < 20; i++) {
            String name = sc.next();
            Double major = Double.parseDouble(sc.next());
            totalMajor += major;
            switch (sc.next()) {
                case "A+":
                    totalGrade += 4.5 * major;
                    break;
                case "A0":
                    totalGrade += 4.0 * major;
                    break;
                case "B+":
                    totalGrade += 3.5 * major;
                    break;
                case "B0":
                    totalGrade += 3.0 * major;
                    break;
                case "C+":
                    totalGrade += 2.5 * major;
                    break;
                case "C0":
                    totalGrade += 2.0 * major;
                    break;
                case "D+":
                    totalGrade += 1.5 * major;
                    break;
                case "D0":
                    totalGrade += 1.0 * major;
                    break;
                case "F":
                    totalGrade += 0.0 * major;
                    break;
                case "P":
                    totalMajor -= major;
                    break;
            }
        }
        // n 번째 소수까지 출력
        System.out.print(String.format("%.6f", totalGrade/totalMajor));
    }
}
