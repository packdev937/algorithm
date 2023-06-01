package study.Assignment;

import java.util.*;

public class Assignment3 {
    static boolean isException;
    private String input;
    private static int index;
    private Map<String, Integer> variables = new HashMap<>();

    private static Deque<Integer> dq;
    private static Stack<String> stack;
    // private static boolean isWhileExecuted = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Assignment3 a = new Assignment3();

        while (true) {
            // Initialization
            dq = new ArrayDeque<>();
            isException = false;
            stack = new Stack<String>();

            System.out.print(">> ");
            String input = scanner.nextLine().replaceAll(" ", "");
            if (input.isEmpty()) {
                break;
            }
            a.setInput(input);
            try {
                if (Character.isAlphabetic(input.charAt(input.length() - 1)))
                    throw new RuntimeException("Syntax Error!");
                else {
                    a.program();
                }
            } catch (Exception e) {
                isException = true;
                System.out.println("Syntax Error!");
            } finally {
                if (!isException) {
                    while (!dq.isEmpty()) {
                        System.out.print(dq.pollFirst() + " ");
                    }
                    System.out.println();
                }
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
            dq.addLast(result);
        } else if (checkString("while")) {
            matchString("(");
            int initialIndex = index;
            int endIndex = index;

            // endIndex를 매핑
            while (!checkString("{")) {
                index++;
            }
            stack.push("{");
            while (index <= input.length()) {
                if (checkString("{"))
                    stack.push("{");
                else if (checkString("}"))
                    stack.pop();
                else {
                    index++;
                }
                if (stack.isEmpty())
                    break;
            }
            if (!stack.isEmpty()) {
                throw new RuntimeException("Syntax Error!");
            }
            endIndex = index;
            index = initialIndex;
            boolean isExecuted;
            while (isExecuted = bexpr()) {
                matchString(")");
                matchString("{");
                while (!checkString("}")) {
                    statement();
                }
                endIndex = index;
                index = initialIndex;
            }
//             만약 while문 안에 있는 statement이 에러면 에러
//             맞다고 해도 그것을 출력하면 안되기 때문에 다시 빼줌
            Map<String, Integer> temp = new HashMap<>();
            for (String key : variables.keySet()) {
                temp.put(key, variables.get(key));
            }
            int len = dq.size();
            if (!isExecuted) {
                try {
                    matchString(")");
                    matchString("{");
                    while (!checkString("}")) {
                        statement();
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Syntax Error!");
                } finally {
                    for (int i = 0; i < dq.size() - len; i++) {
                        dq.pollLast();
                    }
                    for (String key : variables.keySet()) {
                        variables.put(key, temp.get(key));
                    }
                    endIndex = index;
                }
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
        } else if (checkString("<=")) {
            return "<=";
        } else if (checkString(">=")) {
            return ">=";
        } else if (checkString("!=")) {
            return "!=";
        } else if (checkString("<")) {
            return "<";
        } else if (checkString(">")) {
            return ">";
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