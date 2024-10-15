package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1283 {

    private static boolean[] used = new boolean[26]; // 단축키로 사용된 알파벳 체크

    private static class Word {
        private String word;
        private int index = -1; // 단축키로 지정된 인덱스

        public Word(String word) {
            this.word = word;
        }

        public void setIndex() {
            String[] tokens = word.split(" "); // 단어 분리
            for (int i = 0; i < tokens.length; i++) {
	String token = tokens[i];
	// 첫 글자를 단축키로 설정할 수 있는지 확인
	if (!used[Character.toLowerCase(token.charAt(0)) - 'a']) {
	    index = word.indexOf(token); // 단어가 시작되는 위치를 찾기 위해 인덱스를 저장
	    used[Character.toLowerCase(token.charAt(0)) - 'a'] = true;
	    return;
	}
            }

            // 첫 글자가 이미 사용된 경우, 전체 단어를 탐색하여 사용되지 않은 글자를 찾음
            for (int i = 0; i < word.length(); i++) {
	char c = Character.toLowerCase(word.charAt(i));
	if (c != ' ' && !used[c - 'a']) { // 공백이 아닌 문자를 찾음
	    index = i;
	    used[c - 'a'] = true;
	    return;
	}
            }
        }

        @Override
        public String toString() {
            if (index == -1) {
	return word; // 단축키로 지정할 수 없으면 원래 문자열 반환
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
	if (i == index) {
	    result.append("[").append(word.charAt(i)).append("]"); // 단축키로 지정된 글자에 [] 추가
	} else {
	    result.append(word.charAt(i));
	}
            }

            return result.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 옵션 개수 입력
        Word[] words = new Word[N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine(); // 옵션 문자열 입력
            words[i] = new Word(input);
            words[i].setIndex(); // 단축키 설정
        }

        for (Word word : words) {
            System.out.println(word); // 결과 출력
        }
    }
}
