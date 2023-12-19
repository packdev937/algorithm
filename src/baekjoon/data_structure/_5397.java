package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class _5397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for (int j = 0; j < input.length(); j++) {
	char c = input.charAt(j);

	switch (c) {
	    case '<': // 커서를 왼쪽으로 이동
	        if (iter.hasPrevious()) iter.previous();
	        break;
	    case '>': // 커서를 오른쪽으로 이동
	        if (iter.hasNext()) iter.next();
	        break;
	    case '-': // 백스페이스
	        if (iter.hasPrevious()) {
	            iter.previous();
	            iter.remove();
	        }
	        break;
	    default: // 그 외 문자 입력
	        iter.add(c);
	        break;
	}
            }

            // 연결 리스트의 내용을 StringBuilder로 옮겨서 출력
            StringBuilder sb = new StringBuilder();
            for (char ch : list) {
	sb.append(ch);
            }
            System.out.println(sb.toString());
        }

        br.close();
    }
}