package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {

    Queue<int[]> queue = new LinkedList<>();

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int passedTruckCount = 0;
        int currentWeight = 0;
        int currentTime = 0;
        int truckIndex = 0;

        // 모든 트럭이 다 지나갈 때 까지 반복문을 진행합니다.
        while (passedTruckCount != truck_weights.length) {
            // 만약 끝에 도달했다면
            if (!queue.isEmpty()) {
	if (currentTime - queue.peek()[1] == bridge_length) {
	    System.out.println(queue.peek()[0] + "," + queue.peek()[1]);
	    currentWeight -= queue.poll()[0];
	    passedTruckCount++;
	}
            }

            // 다리에 아무도 없다면
            if (truckIndex < truck_weights.length) {
	if (queue.isEmpty()) {
	    queue.add(
	        new int[]{
	            truck_weights[truckIndex], currentTime
	        }
	    );
	    currentWeight += truck_weights[truckIndex++];
	} else { // 다리에 누군가 있다면
	    // bridge_length가 아닌 weight
	    if (currentWeight + truck_weights[truckIndex] <= weight) {
	        queue.add(new int[]{
	            truck_weights[truckIndex],
	            currentTime}
	        );
	        currentWeight += truck_weights[truckIndex++];
	    }
	    // else {
	    //     continue;
	    // }
	}
            }
            currentTime++;
        }

        return currentTime;

    }
}
