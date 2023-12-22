package baekjoon.data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13335 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Truck> trucks = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trucks.offer(new Truck(Integer.parseInt(st.nextToken())));
        }

        Queue<Truck> bridge = new LinkedList<>();
        int totalWeight = 0;
        int time = 0;

        while (!trucks.isEmpty() || !bridge.isEmpty()) {
            time++;
            if (!bridge.isEmpty() && bridge.peek().position == W) {
	totalWeight -= bridge.poll().weight;
            }

            if (!trucks.isEmpty() && totalWeight + trucks.peek().weight <= L) {
	Truck truck = trucks.poll();
	totalWeight += truck.weight;
	bridge.offer(truck);
            }
            moveAlls(bridge);
        }
        System.out.println(time);
    }

    private static void moveAlls(Queue<Truck> bridge) {
        bridge.stream().forEach(t -> t.move());
    }

    static class Truck {

        int weight;
        int position;

        public Truck(int weight) {
            this.weight = weight;
            this.position = 0;
        }

        public int move() {
            return ++position;
        }
    }
}
