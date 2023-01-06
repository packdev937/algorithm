package inflearn.string;

import java.util.Scanner;
import java.util.StringTokenizer;

import java.util.*;
class _10 {
    public int[] solution(String s, char t){
        int[] answer=new int[s.length()];
        int p=1000;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==t){
                p=0;
                answer[i]=p;
            }
            else{
                p++;
                answer[i]=p;
            }
        }
        p=1000;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)==t) p=0;
            else{
                p++;
                answer[i]=Math.min(answer[i], p);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        _10 T = new _10();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        char c=kb.next().charAt(0);
        for(int x : T.solution(str, c)){
            System.out.print(x+" ");
        }
    }
}
// 일단 e가 맨 앞이나 맨 뒤에 올 때 0을 추가해야 되고
// 추가로 Token의 길이가 3일 때는 1 2 1 4 일 때는 1 2 2 1 5일 때는 1 2 3 2 1 이런 식으로 해야 함