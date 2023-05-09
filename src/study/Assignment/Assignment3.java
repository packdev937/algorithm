package study.Assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment3 {
    private String input;
    private static int index;
    private Map<String, Integer> variables = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Assignment3 a = new Assignment3();

        while (true) {
            System.out.print(">> ");
            String input = scanner.nextLine().replaceAll(" ", "");
            if (input.isEmpty()) {
                break;
            }

            a.setInput(input);
            try {
                a.program();
            } catch (Exception e) {
                System.out.println("Syntax Error!");
            }
        }

        scanner.close();
    }

    public void program() throws Exception {
        while (index < input.length()) {
            if (checkString("int")) {
                declaration();
            } else {
                break;
            }
        }
        while (index < input.length()) {
            if (Character.isLowerCase(input.charAt(index))) {
                statement();
            } else {
                throw new RuntimeException("Invalid program");
            }
        }
    }

    public void declaration() throws Exception {
        String varName = var();
        matchString(";");
        variables.put(varName, 0);
    }

    public void statement() throws Exception {
        if (checkString("print")) {
            int result = aexpr();
            matchString(";");
            System.out.println(result);
        } else if (checkString("while")) {
            matchString("(");
            int initialIndex = index;
            int endIndex = index;
            while (bexpr()) {
                matchString(")");
                matchString("{");
                while (!checkString("}")) {
                    statement();
                }
                endIndex = index;
                index = initialIndex;
            }
            index = endIndex;
        } else {
            String varName = var();
            if (checkString("=")) {
                int value = aexpr();
                matchString(";");
                variables.put(varName, value);
            }
        }
    }


    public boolean bexpr() throws Exception {
        int left = aexpr();
        String relop = relop();
        int right = aexpr();

        switch (relop) {
            case "==":
                return left == right;
            case "!=":
                return left != right;
            case "<":
                return left < right;
            case ">":
                return left > right;
            case "<=":
                return left <= right;
            case ">=":
                return left >= right;
            default:
                throw new RuntimeException("Invalid relop");
        }
    }

    public String relop() {
        if (checkString("==")) {
            return "==";
        } else if (checkString("!=")) {
            return "!=";
        } else if (checkString("<")) {
            return "<";
        } else if (checkString(">")) {
            return ">";
        } else if (checkString("<=")) {
            return "<=";
        } else if (checkString(">=")) {
            return ">=";
        } else {
            throw new RuntimeException("Invalid relop");
        }
    }

    public int aexpr() throws Exception {
        int result = term();
        while (true) {
            if (checkString("+")) {
                result += term();
            } else if (checkString("-")) {
                result -= term();
            } else {
                break;
            }
        }
        return result;
    }

    public int term() throws Exception {
        if (Character.isDigit(input.charAt(index))) {
            return number();
        } else if (Character.isLowerCase(input.charAt(index))) {
            return variables.get(var());
        } else {
            throw new RuntimeException("Invalid term");
        }
    }

    public int number() throws Exception {
        if (!Character.isDigit(input.charAt(index)))
            throw new Exception();
        int result = 0;
        while (index < input.length() && Character.isDigit(input.charAt(index))) {
            result = result * 10 + (input.charAt(index) - '0');
            index++;
        }
        return result;
    }

    public String var() {
        if (index < input.length() && Character.isLowerCase(input.charAt(index))) {
            char variable = input.charAt(index);
            index++;
            // 만약 변수가 한 개 이상의 알파벳으로 구성되었다면 Exception 발생
            if (index < input.length() && Character.isLowerCase(input.charAt(index))) {
                throw new RuntimeException("Invalid variable");
            }
            // 만약 변수 초기화가 안되었다면 0으로 초기화
            if (!variables.containsKey(String.valueOf(variable)))
                variables.put(String.valueOf(variable), 0);
            return String.valueOf(variable);
        } else {
            throw new RuntimeException("Invalid variable");
        }
    }

    private void matchString(String s) {
        if (!checkString(s)) {
            throw new RuntimeException("Expected '" + s + "'");
        }
    }

    private boolean checkString(String s) {
        if (input.startsWith(s, index)) {
            index += s.length();
            return true;
        }
        return false;
    }

    public void setInput(String input) {
        this.input = input;
        this.index = 0;
        this.variables = new HashMap<>();
    }
}