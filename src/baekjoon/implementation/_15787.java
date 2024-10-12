package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _15787 {

    static ArrayList<int[]> trains = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            trains.add(new int[21]);  // 1-based indexing을 위해 크기 21로 설정 (1~20 사용)
        }

        int n, x;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());

            switch (option) {
	case 1:
	    n = Integer.parseInt(st.nextToken());
	    x = Integer.parseInt(st.nextToken());
	    trains.get(n)[x] = 1;  // 좌석에 사람을 태움
	    break;
	case 2:
	    n = Integer.parseInt(st.nextToken());
	    x = Integer.parseInt(st.nextToken());
	    trains.get(n)[x] = 0;  // 좌석에서 사람을 내림
	    break;
	case 3:
	    n = Integer.parseInt(st.nextToken());
	    for (int j = 20; j > 1; j--) {
	        trains.get(n)[j] = trains.get(n)[j - 1];
	    }
	    trains.get(n)[1] = 0;
	    break;
	case 4:
	    n = Integer.parseInt(st.nextToken());
	    for (int j = 1; j < 20; j++) {
	        trains.get(n)[j] = trains.get(n)[j + 1];
	    }
	    trains.get(n)[20] = 0;
	    break;
            }
        }

        // 모든 열차의 좌석 상태를 비트마스크로 변환
        for (int j = 1; j <= N; j++) {
            int bitMask = 0;
            for (int k = 1; k <= 20; k++) {
	if (trains.get(j)[k] == 1) {
	    bitMask |= (1 << (k - 1));  // 해당 좌석이 차 있으면 비트 설정
	}
            }
            set.add(bitMask);  // 비트마스크를 set에 추가
        }

        // 중복되지 않는 좌석 상태의 개수 출력
        System.out.println(set.size());
    }
}
