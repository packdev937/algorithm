package baekjoon.back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class _28466 {

    static class Person {

        int score;
        int cheon;
        int ji;
        Integer hashCode;

        public Person(int score, int cheon, int ji) {
            this.score = score;
            this.cheon = cheon;
            this.ji = ji;
        }

        // hashcode()와 equals()를 모두 Override
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Person)) {
                return false;
            }

            Person p = (Person) obj;
            if (p.score == score && p.cheon == cheon && p.ji == ji) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(score, cheon, ji);
        }

    }

    static HashMap<Person, Integer> map = new HashMap<>();
    static int[][] cheon = new int[10][10];
    static int[][] ji = new int[12][12];
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < cheon.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cheon.length; j++) {
                cheon[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < ji.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < ji.length; j++) {
                ji[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            Person person = new Person(Integer.parseInt(s[0]),
                Character.getNumericValue(s[1].charAt(0)), s[1].charAt(1) - 'A');
            map.put(person, map.getOrDefault(person, 0) + 1);
        }

        for (Map.Entry<Person, Integer> i : map.entrySet()) {
            i.setValue(i.getValue() - 1);

            for (Map.Entry<Person, Integer> j : map.entrySet()) {
                if (j.getValue() <= 0) {
                    continue;
                }

                j.setValue(j.getValue() - 1);

                for (Map.Entry<Person, Integer> k : map.entrySet()) {
                    if (k.getValue() <= 0) {
                        continue;
                    }
                    MAX = Math.max(MAX, calculate(i.getKey(), j.getKey(), k.getKey()));
                }

                j.setValue(j.getValue() + 1);
            }

            i.setValue(i.getValue() + 1);
        }

        System.out.println(MAX);
    }

    public static int calculate(Person key1, Person key2, Person key3) {
        int answer = 0;
        answer = key1.score + key2.score + key3.score;
        answer += (cheon[key1.cheon][key2.cheon] + cheon[key1.cheon][key3.cheon]
            + cheon[key2.cheon][key3.cheon]);
        answer += (ji[key1.ji][key2.ji] + ji[key1.ji][key3.ji] + ji[key2.ji][key3.ji]);
        return answer;
    }
}
