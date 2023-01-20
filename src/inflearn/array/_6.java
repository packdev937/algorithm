package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class _6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int max = 0;

        for (int i = 0; i < s.length; i++) {
            String temp = "";
            for (int j = 0; j < s[i].length(); j++) {
//                if (s[i].charAt(s[i].length() - 1 - j) == '0')
//                    continue;
                temp += s[i].charAt(s[i].length() - 1 - j);
            }
            if (Integer.parseInt(temp) > max)
                max = Integer.parseInt(temp);
            s[i] = temp;
        }

        int[] arr = new int[max + 1];

        for (int i = 2; i <= max; i++) {
            if (arr[i] == 0) {
                arr[i] = 2;
                for (int j = i; j <= max; j += i) {
                    if (arr[j] == 2) continue;
                    arr[j] = 1;
                }
            }
        }


        for (int i = 0; i < s.length; i++) {
            if (arr[Integer.parseInt(s[i])] == 2)
                System.out.print(Integer.parseInt(s[i]) + " ");
        }
    }
}


// 110 을 뒤집으면 011이 된다. 하지만 Integer.parseInt 하면 앞 뒤의 0은 생략된다