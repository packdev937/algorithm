package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _23632 {

    static boolean[] building, resources;
    static int[] in_degree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> resource = new ArrayList<>();

    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        building = new boolean[N + 1];
        resources = new boolean[N + 1];
        in_degree = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            building[Integer.parseInt(st.nextToken())] = true;
        }
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            resource.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                resource.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < N - M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            in_degree[a] = b;
            for (int j = 0; j < b; j++) {
                graph.get(Integer.parseInt(st.nextToken())).add(a);
            }
        }

        // Initial Setup
        for (int i = 1; i < in_degree.length; i++) {
            if (in_degree[i] == 0) {
                queue.add(new int[]{i, 0});
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (temp[1] > T) {
                break;
            }

            answer.add(temp[0]);
            for (int i = 0; i < resource.get(temp[0]).size(); i++) {
                int res = resource.get(temp[0]).get(i);
                if (resources[res]) {
                    continue;
                }

                resources[res] = true;

                for (int j = 0; j < graph.get(res).size(); j++) {
                    in_degree[graph.get(res).get(j)]--;
                    if (in_degree[graph.get(res).get(j)] == 0) {
                        queue.add(new int[]{graph.get(res).get(j), temp[1] + 1});
                    }
                }

            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
}
