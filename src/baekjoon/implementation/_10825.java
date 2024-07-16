package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _10825 {

    private static StringTokenizer st;
    private static Student[] students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        students = new Student[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()),
	Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(students);
        for (Student student : students) {
            System.out.println(student.name);
        }
    }

    static class Student implements Comparable<Student> {

        private String name;
        private int koreanScore;
        private int englishScore;
        private int mathScore;

        public Student(String name, int koreanScore, int englishScore, int mathScore) {
            this.name = name;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        @Override
        public int compareTo(Student o) {
            if (this.koreanScore != o.koreanScore) {
	return o.koreanScore - this.koreanScore;
            } else if (this.englishScore != o.englishScore) {
	return this.englishScore - o.englishScore;
            } else if (this.mathScore != o.mathScore) {
	return o.mathScore - this.mathScore;
            } else {
	return this.name.compareTo(o.name);
            }
        }
    }
}
