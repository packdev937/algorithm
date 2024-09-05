package baekjoon.graph.bellman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class _11657 {

    static StringTokenizer st;
    static StringBuilder sb;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        // 도시의 개수
        int N = Integer.parseInt(st.nextToken());

        // 음의 간선이 -10,000 일 경우 -300억으로 오버플로우가 발생할 수 있음
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // 버스 노선의 개수
        int M = Integer.parseInt(st.nextToken());

        List<Bus> busList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Bus bus = new Bus(
	Integer.parseInt(st.nextToken()),
	Integer.parseInt(st.nextToken()),
	Integer.parseInt(st.nextToken())
            );
            busList.add(bus);
        }

        // 도시의 개수 -1 만큼 반복 (마지막 횟수는 음의 사이클을 확인하기 위함)
        for (int i = 0; i <= N; i++) {
            // 버스의 개수
            for (int j = 0; j < M; j++) {
	Bus bus = busList.get(j);
	// 출발 지점이 INF 라면 무시
	if (dist[bus.from] == INF) {
	    continue;
	}

	// 도착지점 > 출발지점 + 가중치라면 갱신
	if (dist[bus.to] > dist[bus.from] + bus.weight) {
	    dist[bus.to] = dist[bus.from] + bus.weight;

	    // N번째에서도 갱신이 된다면 음의 사이클이 존재한다는 의미
	    if (i == N) {
	        System.out.println(-1);
	        return;
	    }
	}
            }
        }

        // 2번 도시 부터 출력
        for (int i = 2; i < dist.length; i++) {
            sb.append(dist[i] == INF ? -1 : dist[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    static class Bus {

        int from;
        int to;
        int weight;

        public Bus(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

}

// # 출력 초과가 뜨는 이유