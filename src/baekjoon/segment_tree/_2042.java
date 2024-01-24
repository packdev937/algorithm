package baekjoon.segment_tree;

import java.io.*;
import java.util.StringTokenizer;

public class _2042 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] array = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            array[i] = Long.parseLong(br.readLine());
        }

        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.init(array, 1, 1, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == 1) {
	long C = Long.parseLong(st.nextToken());
	segmentTree.update(1, 1, N, B, C);
	continue;
            }
            int C = Integer.parseInt(st.nextToken());
            long result = segmentTree.sum(1, 1, N, B, C);

            bw.write(String.valueOf(result));
            bw.newLine();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class SegmentTree {

        private long[] tree;

        SegmentTree(int n) {
            // 트리의 높이 계산
            double treeHeight = Math.ceil(Math.log(n) / Math.log(2)) + 1;
            // 트리의 노드 수 계산
            long treeNodeCount = Math.round(Math.pow(2, treeHeight));
            // 트리의 길이 설정
            tree = new long[Math.toIntExact(treeNodeCount)];
        }

        long init(long[] arr, int node, int start, int end) {
            // 리프 노드일 때
            if (start == end) {
	return tree[node] = arr[start];
            } else {
	// 리프 노드가 아닐 경우 그 값은 자식 노드 (2n 노드와 2n+1 노드)의 합
	return tree[node] = init(arr, node * 2, start, (start + end) / 2)
	    + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
            }
        }

        long sum(int node, int start, int end, int left, int right) {
            if (end < left || right < start) {
	return 0;
            } else if (left <= start && end <= right) {
	return tree[node];
            } else {
	return sum(node * 2, start, (start + end) / 2, left, right)
	    + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
            }
        }

        long update(int node, int start, int end, int index, long changeValue) {
            if (index < start || end < index) {
	return tree[node];
            } else if (start == index && end == index) {
	return tree[node] = changeValue;
            } else {
	return tree[node] =
	    update(node * 2, start, (start + end) / 2, index, changeValue) +
	        update(node * 2 + 1, (start + end) / 2 + 1, end, index, changeValue);
            }
        }
    }
}