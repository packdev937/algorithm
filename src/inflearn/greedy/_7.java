package inflearn.greedy;

import java.util.*;

class Road implements Comparable<Road> {
    int v1, v2, weight;

    public Road(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Road o) {
        return this.weight - o.weight;
    }
}

public class _7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<Road> list = new ArrayList<>();
        List<Road> spanning = new LinkedList<>();

        for (int i = 0; i < E; i++) {
            list.add(new Road(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);
        // Collections의 오름차순 정렬이 잘되었는지 확인하였음
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("list.get(i).weight = " + list.get(i).weight);
//        }

        for (int i = 0; i < list.size(); i++) {
            
        }
    }
}

// 우선 list에 각 정점의 연결 정보를 weight를 기준으로 내림차순으로 입력 받는다
// 각 vertex는 cycle이 존재하면 안되기에 cycle을 방지할 수 있는 하나의 배열을 선언한다
// 코드의 동작 순서는 다음과 같다
// 1. 작은 vertex 부터 graph에 vertex를 추가해 나간다
// 2. 해당 추가는 for문에서 이뤄지며 for 문 안에 if 문을 통해 cycle의 여부를 확인한다
// 3. 최종적으로 cycle이 안되는 것이 확인되면 graph에 추가하고 total에 weight를 추가한다. 