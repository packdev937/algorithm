package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _15828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bufferSize = Integer.parseInt(br.readLine());
        Queue<Integer> buffer = new LinkedList<>();
        int size = 0;

        while (true) {
            int packet = Integer.parseInt(br.readLine());

            if (packet == -1) {
	break;
            }

            if (packet == 0) {
	if (!buffer.isEmpty()) {
	    buffer.poll();
	    size--;
	}
	continue;
            }

            if (size < bufferSize) {
	buffer.add(packet);
	size++;
            }
        }

        br.close(); // Close BufferedReader

        if (buffer.isEmpty()) {
            System.out.println("empty");
        } else {
            while (!buffer.isEmpty()) {
	System.out.print(buffer.poll() + " ");
            }
        }
    }
}
