package inflearn.data_structure;

import java.util.HashMap;
import java.util.Scanner;

public class _4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        int length = T.length();
        int cnt = 0;

        for (int i = 0; i <= S.length()-length; i++) {
            String s = S.substring(i, i+length);
            if(isAnagram(s, T))
                cnt++;
        }

        System.out.print(cnt);
    }

    public static boolean isAnagram(String S, String T){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : S.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : T.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)-1);
        }

        for(char c : map.keySet()){
            if(map.get(c) != 0){
                return false;
            }
        }

        return true;
    }
}
