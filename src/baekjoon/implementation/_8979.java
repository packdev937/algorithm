package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _8979 {

    private static class Country implements Comparable<Country> {

        private int id;
        private int goldCount;
        private int silverCount;
        private int bronzeCount;

        public Country(int id, int goldCount, int silverCount, int bronzeCount) {
            this.id = id;
            this.goldCount = goldCount;
            this.silverCount = silverCount;
            this.bronzeCount = bronzeCount;
        }

        public int getId() {
            return id;
        }

        public int getGoldCount() {
            return goldCount;
        }

        public int getSilverCount() {
            return silverCount;
        }

        public int getBronzeCount() {
            return bronzeCount;
        }

        @Override
        public int compareTo(Country o) {
            // 금, 은, 동 메달 수가 많은 순으로 내림차순 정렬
            if (this.goldCount != o.goldCount) {
	return o.goldCount - this.goldCount;
            }
            if (this.silverCount != o.silverCount) {
	return o.silverCount - this.silverCount;
            }
            return o.bronzeCount - this.bronzeCount;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Country> countries = new ArrayList<>();
        Collections.sort(countries);

        int rank = 1;
        int sameCount = 0;
        Country prevCountry = null;

        for (int i = 0; i < countries.size(); i++) {
            Country current = countries.get(i);

            if (prevCountry != null) {
	if (current.getGoldCount() == prevCountry.getGoldCount() &&
	    current.getSilverCount() == prevCountry.getSilverCount() &&
	    current.getBronzeCount() == prevCountry.getBronzeCount()) {
	    sameCount++;
	} else {
	    rank += sameCount + 1;
	    sameCount = 0;
	}
            }

            if (current.getId() == K) {
	System.out.println(rank);
	break;
            }

            prevCountry = current;
        }

        br.close();
    }
}
