package baekjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _11652 {

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int max = 0;
        int maxNum = 0;
        for (int key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                maxNum = key;
            }
        }

        System.out.print(maxNum);
    }

}
