package programmers.lv2;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class 방문_길이 {
    class Path {
        int fromX;
        int fromY;
        int toX;
        int toY;

        public Path(int[] from, int[] to) {
            this.fromX = from[1];
            this.fromY = from[0];
            this.toX = to[1];
            this.toY = to[0];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
	return true;
            }
            if (o == null || getClass() != o.getClass()) {
	return false;
            }
            Path p = (Path) o;
            return (p.fromX == this.fromX && p.fromY == this.fromY && p.toX == this.toX && p.toY == this.toY) ||
	(p.fromX == this.toX && p.fromY == this.toY && p.toX == this.fromX && p.toY == this.fromY);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Math.min(fromX, toX), Math.min(fromY, toY), Math.max(fromX, toX), Math.max(fromY, toY));
        }
    }

    class Solution {
        Set<Path> paths = new HashSet<>();
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        Map<Character, Integer> directionMap = Map.of(
            'U', 2,
            'R', 1,
            'D', 0,
            'L', 3
        );

        public int solution(String dirs) {
            int[] current = new int[]{0, 0};

            for (char dir : dirs.toCharArray()) {
	int direction = directionMap.get(dir);
	int[] next = {current[0] + dy[direction], current[1] + dx[direction]};

	if (next[0] > 5 || next[0] < -5 || next[1] > 5 || next[1] < -5) {
	    continue;
	}

	paths.add(new Path(current, next));
	current = next;
            }

            return paths.size();
        }
    }
}
