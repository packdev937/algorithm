package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _1331 {

    public static int currentX, currentY, prevX, prevY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> visit = new ArrayList<String>();
        String st = br.readLine();

        int startX = st.charAt(0);
        int startY = st.charAt(1);
        prevX = startX;
        prevY = startY;

        visit.add(st);

        for (int i = 0; i < 35; i++) {
            String s = br.readLine();
            currentX = s.charAt(0);
            currentY = s.charAt(1);

            if (visit.contains(s)) {
	System.out.println("Invalid");
	return;
            }

            if (Math.abs(currentX - prevX) == 2 && Math.abs(currentY - prevY) == 1
	|| Math.abs(currentX - prevX) == 1
	&& Math.abs(currentY - prevY) == 2) {

            } else {
	System.out.println("Invalid");
	return;
            }

            visit.add(s);
            prevX = currentX;
            prevY = currentY;
        }

        if (Math.abs(currentX - startX) == 2 && Math.abs(currentY - startY) == 1
            || Math.abs(currentX - startX) == 1
            && Math.abs(currentY - startY) == 2) {

        } else {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");
    }

}
