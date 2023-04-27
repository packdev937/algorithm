package baekjoon.sort;

import java.util.*;

public class _2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        double total = 0;
        int max = 0;
        int cnt = -1;
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Arrays.sort(arr);
        Collections.sort(keySet);

        boolean isSecond = false;
        for (Integer key : keySet) {
            if (map.get(key) > cnt) {
                isSecond = false;
                cnt = map.get(key);
                max = key;
            } else if (map.get(key) == cnt && !isSecond) {
                isSecond = true;
                cnt = map.get(key);
                max = key;
            }
        }

        System.out.println(Math.round(total / arr.length));
        System.out.println(arr[arr.length / 2]);
        System.out.println(max);
        System.out.println(arr[arr.length - 1] - arr[0]);
    }
}
