package baekjoon.topology_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _21276 {

    static HashMap<String, Integer> inDegree = new HashMap<>();
    static HashMap<String, ArrayList<String>> graph = new HashMap<>();
    static HashMap<String, ArrayList<String>> children = new HashMap<>();
    static PriorityQueue<String> queue = new PriorityQueue<>(); // 사전순 정렬을 위해 PriorityQueue 사용
    static HashSet<String> initialQueueElements = new HashSet<>(); // 초기 큐에 추가된 요소들을 추적

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] names = br.readLine().split(" ");
        Arrays.sort(names); // 이름을 사전순으로 정렬

        for (String name : names) {
            inDegree.put(name, 0);
            graph.put(name, new ArrayList<>());
            children.put(name, new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();
            inDegree.put(child, inDegree.get(child) + 1);
            graph.get(parent).add(child);
        }

        for (String name : names) {
            if (inDegree.get(name) == 0) {
	queue.add(name);
	initialQueueElements.add(name);
            }
        }

        ArrayList<String> ancestors = new ArrayList<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (initialQueueElements.contains(current)) {
	ancestors.add(current);
            }

            for (String child : graph.get(current)) {
	inDegree.put(child, inDegree.get(child) - 1);
	if (inDegree.get(child) == 0) {
	    queue.add(child);
	    children.get(current).add(child);
	}
            }
        }

        System.out.println(ancestors.size());
        for (String ancestor : ancestors) {
            System.out.print(ancestor + " ");
        }
        System.out.println();

        for (String name : names) {
            Collections.sort(children.get(name));
            System.out.print(name + " " + children.get(name).size() + " ");
            for (String child : children.get(name)) {
	System.out.print(child + " ");
            }
            System.out.println();
        }
    }
}
