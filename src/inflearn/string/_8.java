package inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ,./;:'[{}]");
        boolean isPelindrome = true;
        int n = st.countTokens();
        String str1 = "", str2 = "";
        for (int i = 0; i < n / 2; i++) {
            str1 += st.nextToken().toUpperCase();
        }
        for (int i = 0; i < n / 2; i++) {
            str2 += st.nextToken().toUpperCase();
        }
        System.out.println(str1+","+str2);
        for (int j = 0; j < str1.length()/2; j++) {
            if (str1.charAt(j) != str2.charAt(str2.length() - 1 - j)) {
                isPelindrome = false;
                break;
            }
        }
        if (isPelindrome)
            System.out.println("YES");
        else System.out.println("NO");
    }
}

// 알파벳 이외으 문자들을 어떻게 무시할까?