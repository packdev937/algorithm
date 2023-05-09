package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Tree {
    Node root = null;

    public void add(String data, String leftData, String rightData) {
        if (root == null) {
            if (!data.equals("."))
                root = new Node(data);
            if (!leftData.equals("."))
                root.leftNode = new Node(leftData);
            if (!rightData.equals("."))
                root.rightNode = new Node(rightData);
        } else {
            search(root, data, leftData, rightData);
        }
    }

    public void search(Node root, String data, String leftData, String rightData) {
        if (root == null)
            return;

        else if (root.data.equals(data)) {
            if (!leftData.equals("."))
                root.leftNode = new Node(leftData);
            if (!rightData.equals("."))
                root.rightNode = new Node(rightData);
        } else {
            search(root.leftNode, data, leftData, rightData);
            search(root.rightNode, data, leftData, rightData);
        }
    }


    public void preOrder(Node node) {
        System.out.print(node.data);

        if (node.leftNode != null)
            preOrder(node.leftNode);
        if (node.rightNode != null)
            preOrder(node.rightNode);
    }

    public void inOrder(Node node) {
        if (node.leftNode != null)
            inOrder(node.leftNode);
        System.out.print(node.data);
        if (node.rightNode != null)
            inOrder(node.rightNode);
    }

    public void postOrder(Node node) {
        if (node.leftNode != null)
            postOrder(node.leftNode);
        if (node.rightNode != null)
            postOrder(node.rightNode);
        System.out.print(node.data);
    }
}

class Node {
    public String data;
    public Node leftNode, rightNode;

    public Node(String data) {
        this.data = data;
    }
}

public class _1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            tree.add(input[0], input[1], input[2]);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
    }
}

// #1 String을 equals로 비교하는 것
// #2 BufferedReader로 받았을 때는 String [], split(" ")을 활용
// #3 Tree Class와 Node Class를 이용