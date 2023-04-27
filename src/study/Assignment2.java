package study;

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
            System.out.println(input);
            if (a.validateString(input)) {
                System.out.println("Invalid Character is entered");
                ;
                continue;
            }
            if (input.contains("=") || input.contains("<") || input.contains(">"))
                isBexpr = true;
            else isBexpr = false;

            if (input.isEmpty()) {
                break;
            }

            a.setInput(input);
            try {
                Object result = a.expr();
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("syntax error!!");
            }
        }

        scanner.close();
    }

    public boolean validateString(String input) {
        if (input.contains("_") || input.contains("@") || input.contains("#") || input.contains("$") || input.contains("%") || input.contains("^") || input.contains("&")) {
            return true;
        } else return false;
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
        System.out.println(input.charAt(index));
        int right = aexpr();

        System.out.println(left + " " + right);
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
        if (consume("==")) {
            return "==";
        } else if (consume("!=")) {
            return "!=";
        } else if (consume("<")) {
            return "<";
        } else if (consume(">")) {
            return ">";
        } else if (consume("<=")) {
            return "<=";
        } else if (consume(">=")) {
            return ">=";
        } else {
            throw new RuntimeException("Invalid relop");
        }
    }

    public int aexpr() throws Exception {
        int result = term();
        while (true) {
            if (consume("*")) {
                result *= term();
            } else if (consume("/")) {
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
            if (consume("+")) {
                result += factor();
            } else if (consume("-")) {
                result -= factor();
            } else {
                break;
            }
        }
        return result;
    }

    public int factor() throws Exception {
        if (consume("(")) {
            int result = aexpr();
            match(")");
            return result;
        } else if (consume(")")) {
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

    private void match(String s) {
        if (!consume(s)) {
            throw new RuntimeException("Expected '" + s + "'");
        }
    }

    private boolean consume(String s) {
        if (input.startsWith(s, index)) {
            index += s.length();
            return true;
        }
        return false;
    }
}
