package programmers.lv1;

public class 단어_변환 {
    boolean[] ch;
    int cnt = 0;

    public int solution(String begin, String target, String[] words) {
        ch = new boolean[words.length];
        boolean isIn = false;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target))
                isIn = true;
        }
        if (isIn)
            dfs(begin, target, words, -1);
        else return 0;
        return cnt;
    }

    public void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            cnt = count;
            return;
        } else {
            for (int i = 0; i < words.length; i++) {
                int cntStr = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    if (begin.charAt(j) == words[i].charAt(j)) {
                        cntStr++;
                    }
                    if (cntStr == begin.length() - 1 && !ch[i]) {
                        ch[i] = true;
                        dfs(words[i], target, words, count + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        단어_변환 T = new 단어_변환();
        System.out.println(T.solution("hit", "cog",
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(T.solution("hit", "cog",
                new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}
