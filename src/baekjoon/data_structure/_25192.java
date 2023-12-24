package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _25192 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Set<String> imoticon = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
	answer += imoticon.size();
	imoticon.clear();
            } else {
	imoticon.add(input);
            }
        }
        answer += imoticon.size();
        System.out.println(answer);
    }

}
