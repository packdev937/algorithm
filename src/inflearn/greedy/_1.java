package inflearn.greedy;

import java.util.Scanner;

class Volunteer {
    public int height, weight;

    public Volunteer(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
}

public class _1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Volunteer[] arr = new Volunteer[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Volunteer(sc.nextInt(), sc.nextInt());
        }

        boolean isTrue;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            isTrue = true;
            Volunteer temp = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (i == j)
                    continue;
                else {
                    Volunteer comp = arr[j];
                    if (temp.height < comp.height && temp.weight < comp.weight) {
                        isTrue = false;
                        break;
                    }
                }
            }
            if (isTrue) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
