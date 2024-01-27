package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _20546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] stocks = new int[14];

        int money = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < stocks.length; i++) {
            stocks[i] = Integer.parseInt(st.nextToken());
        }

        int JH = money, SM = money;
        int JHStock = 0, SMStock = 0;
        int upCount = 0, downCount = 0;

        // JH
        for (int i = 0; i < stocks.length; i++) {
            if (JH >= stocks[i]) {
	JHStock += JH / stocks[i];
	JH %= stocks[i];
            }
        }

        // SM
        for (int i = 1; i < stocks.length; i++) {
            if (stocks[i] > stocks[i - 1]) {
	upCount++;
	downCount = 0;
            } else if (stocks[i] < stocks[i - 1]) {
	downCount++;
	upCount = 0;
            } else {
	upCount = 0;
	downCount = 0;
            }

            if (upCount >= 3) {
	SM += SMStock * stocks[i];
	SMStock = 0;
            } else if (downCount >= 3 && SM >= stocks[i]) {
	SMStock += SM / stocks[i];
	SM %= stocks[i];
            }
        }

        // 최종 자산 계산
        JH += JHStock * stocks[stocks.length - 1];
        SM += SMStock * stocks[stocks.length - 1];

        if (JH > SM) {
            System.out.print("BNP");
        } else if (JH < SM) {
            System.out.print("TIMING");
        } else {
            System.out.print("SAMESAME");
        }
    }
}
