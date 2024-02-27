package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        if (isC(input)) {
            System.out.print(convertToJava(input));
        } else if (isJava(input)) {
            System.out.print(convertToC(input));
        } else {
            System.out.print("Error!");
        }
    }

    private static boolean isJava(String input) {
        // Check if the input starts with a lowercase letter and does not contain '_'
        return input.matches("^[a-z][a-zA-Z0-9]*$") && !input.contains("_");
    }

    private static boolean isC(String input) {
        // Check for C naming conventions, avoiding leading/trailing underscores and consecutive underscores
        return !input.contains("__") && !input.startsWith("_") && !input.endsWith("_") && input.matches("^[a-z][a-z0-9_]*$");
    }

    private static String convertToJava(String input) {
        StringBuilder sb = new StringBuilder();
        boolean nextUpper = false;
        for (char ch : input.toCharArray()) {
            if (ch == '_') {
	nextUpper = true;
            } else {
	sb.append(nextUpper ? Character.toUpperCase(ch) : ch);
	nextUpper = false;
            }
        }
        return sb.toString();
    }

    private static String convertToC(String input) {
        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
	sb.append("_").append(Character.toLowerCase(ch));
            } else {
	sb.append(ch);
            }
        }
        return sb.toString();
    }
}
