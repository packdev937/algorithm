package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _26069 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> dance = new HashSet<>();
        dance.add("ChongChong");

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String firstPerson = st.nextToken();
            String secondPerson = st.nextToken();
            if (dance.contains(firstPerson)) {
	dance.add(secondPerson);
            } else if(dance.contains(secondPerson)) {
	dance.add(firstPerson);
            }
        }

        System.out.println(dance.size());
    }
}
