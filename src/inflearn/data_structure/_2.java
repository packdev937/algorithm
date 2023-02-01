package inflearn.data_structure;

import java.util.HashMap;
import java.util.Scanner;

public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            map1.put(str1.charAt(i),map1.getOrDefault(str1.charAt(i),0)+1);
        }


        for (int i = 0; i < str2.length(); i++) {
            map2.put(str2.charAt(i),map2.getOrDefault(str2.charAt(i),0)+1);
        }

        boolean isTrue = true;
        for(char x:map1.keySet()){
            if(map1.get(x) != map2.get(x)){
                isTrue = false;
                break;
            }
        }

        if(isTrue)
            System.out.println("YES");
        else System.out.println("NO");
    }
}
