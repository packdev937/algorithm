package study.Assignment;

import java.util.Scanner;

public class Assignment2 {
    private String input;
    private static int index;
    private static boolean isBexpr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Assignment2 a = new Assignment2();

        while (true) {
            System.out.print(">> ");
            String input = scanner.nextLine().replaceAll(" ", "");
            if (a.validateString(input)) {
                System.out.println("Invalid Character is entered");
                continue;
            }

            if (input.contains("=") || input.contains("<") || input.contains(">"))
                isBexpr = true;
            else isBexpr = false;

            if (input.isEmpty()) {
                break;
            }

            // index와 input을 초기화
            a.setInput(input);
            try {
                Object result = a.expr();
                System.out.println(result);
            } catch (ArithmeticException e) {
                System.out.println("arithmetic exception!!");
            } catch (Exception e) {
                System.out.println("syntax error!!");
            }
        }

        scanner.close();
    }

    public boolean validateString(String input) {
        if (input.contains("_") || input.contains("@") || input.contains("#") ||
                input.contains("$") || input.contains("%") || input.contains("^") ||
                input.contains("&") || input.contains("~")) {
            return true;
        } else {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == '!') {
                    if (i + 1 >= input.length() || input.charAt(i + 1) != '=') {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public void setInput(String input) {
        this.input = input;
        this.index = 0;
    }

    public Object expr() throws Exception {
        if (isBexpr) {
            return bexpr();
        } else {
            return aexpr();
        }
    }

    public Object bexpr() throws Exception {
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
            if (checkString("*")) {
                result *= term();
            } else if (checkString("/")) {
                result /= term();
            } else {
                break;
            }
        }
        return result;
    }

    public int term() throws Exception {
        int result = factor();
        while (true) {
            if (checkString("+")) {
                result += factor();
            } else if (checkString("-")) {
                result -= factor();
            } else {
                break;
            }
        }
        return result;
    }

    public int factor() throws Exception {
        if (checkString("(")) {
            int result = aexpr();
            matchString(")");
            return result;
        } else if (checkString(")")) {
            throw new RuntimeException(") should be appeared behind of (");
        } else {
            return number();
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
}
