package inflearn.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _6 {
    public static void main(String[] args) {
        Deque<Integer> q = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // Intialization
        for(int i = 0; i<N; i++){
            q.addLast(i+1);
        }

        // Start
        int cnt = 0;
        while(q.size() != 1){
            ++cnt;
            if(cnt == K){
                q.removeFirst();
                cnt = 0;
            }
            else {
                int temp = q.removeFirst();
                q.addLast(temp);
            }
        }
        System.out.println(q.poll());
    }
}
