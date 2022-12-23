package implementation;

import java.util.Scanner;

public class _2530 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int hr = sc.nextInt();
        int min = sc.nextInt();
        int sec = sc.nextInt();
        int cookTime = sc.nextInt();

        // 계산
        sec += cookTime;
        if (sec >= 60) {
            min += sec / 60;
            sec %= 60;
        }
        if (min >= 60) {
            hr += min / 60;
            min %= 60;
        }
        if (hr >= 24) {
            hr %= 24;
        }

        // 출력
        System.out.println(hr + " " + min + " " + sec);
    }
}
