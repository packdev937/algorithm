package programmers.lv1;

public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < answer.length; i++) {
            String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            s = s.replace("1", "#");
            s = s.replace("0", " ");
            String temp = "";
            if (s.length() != n) {
                temp = "";
                for (int j = 0; j < n - s.length(); j++) {
                    temp += ' ';
                }
            }
            s = temp + s;
            answer[i] = s;
        }
        return answer;
    }

    public static void main(String[] args) {
        비밀지도 T = new 비밀지도();
        int[] arr1 = new int[]{9, 20, 28, 18, 11};
        int[] arr2 = new int[]{30, 1, 21, 17, 28};
        String[] answer = T.solution(5, arr1, arr2);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }
}

// 길이를 맞추기 위해 다음 코드를 썼지만 마음에 안든다
//String temp = "";
//            if (s.length() != n) {
//                    temp = "";
//                    for (int j = 0; j < n - s.length(); j++) {
//        temp += ' ';
//        }
//        }

