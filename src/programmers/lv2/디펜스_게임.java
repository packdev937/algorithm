package programmers.lv2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 디펜스_게임 {
    PriorityQueue<Integer> pq = new PriorityQueue<>(
        new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
	return o2 - o1;
            }
        }
    );

    public int solution(int n, int k, int[] enemy) {
        int life = n;
        int chance = k;
        int answer = enemy.length;

        for (int i = 0; i < enemy.length; i++) {
            life -= enemy[i];
            pq.add(enemy[i]);

            if (life < 0) {
	if (chance > 0 && !pq.isEmpty()) {
	    life += pq.poll();
	    chance--;
	} else {
	    answer = i;
	    break;
	}
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        디펜스_게임 M = new 디펜스_게임();
        int n = 2;
        int k = 4;
        int[] enemy = {3, 3, 3, 3};
        System.out.println(M.solution(n, k, enemy));
    }

}
