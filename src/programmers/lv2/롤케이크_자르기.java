package programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class 롤케이크_자르기 {
    class Solution {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        public int solution(int[] topping) {
            int answer = 0;

            int [] dpA = new int [topping.length];
            int [] dpB = new int [topping.length];

            for(int i = 0; i<topping.length; i++){
	setA.add(topping[i]);
	setB.add(topping[topping.length-1-i]);

	dpA[i] = setA.size();
	dpB[topping.length-1-i] = setB.size();
            }

            for(int i = 0; i<dpA.length-1; i++){
	if(dpA[i] == dpB[i+1]){
	    answer++;
	}
            }

            return answer;
        }
    }
}
