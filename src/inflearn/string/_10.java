package inflearn.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class _10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        StringTokenizer st = new StringTokenizer(str, Character.toString(c));

        // 첫 번째는 토큰에 포함되지 않음
        if(str.charAt(0) == c) System.out.print("0 ");

        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            System.out.print(temp+"@@");
            int len = temp.length();
            int cnt = 1;
            for (int i = 0; i < len / 2; i++) {
                System.out.print(cnt++ + " ");
            }
            if(len%2 ==0) cnt--;
            for(int i = len/2; i<len; i++){
                System.out.print(cnt-- + " ");
            }

            System.out.print("0 ");
        }
    }
}

// 일단 e가 맨 앞이나 맨 뒤에 올 때 0을 추가해야 되고
// 추가로 Token의 길이가 3일 때는 1 2 1 4 일 때는 1 2 2 1 5일 때는 1 2 3 2 1 이런 식으로 해야 함