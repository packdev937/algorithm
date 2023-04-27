package programmers;

import java.util.Stack;

public class test {
    public int solution(int[] ingredient) {
        int answer = 0;
        String str = "";
        for (int i = 0; i < ingredient.length; i++) {
            str+=String.valueOf(ingredient[i]);
        }

        for (int i = 0; i < str.length(); i++) {
            answer++;
            str = str.replaceAll("1234","");
        }

//        for (int j = 0; j < ingredient.length; j++) {
//            for (int i = 0; i < str.length() - 3; i++) {
//                String t = str.substring(i,i+4);
//                if (str.substring(i, i + 4).equals("1231")) {
//                    answer++;
//                    str = str.replace("1231", "");
//                    break;
//                }
        return answer;
    }

    public static void main(String[] args) {
        test t = new test();
        int [] arr = {2,1,1,2,3,1,2,3,1};
        System.out.println(t.solution(arr));
    }
}
