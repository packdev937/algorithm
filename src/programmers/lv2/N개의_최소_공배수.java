package programmers.lv2;

public class N개의_최소_공배수 {
    public int solution(int[] arr) {
        int answer = 0;
        for(int i = 1; i < arr.length; i++){
            answer = lcm(arr[i-1], arr[i]);
            arr[i] = answer;
        }

        return arr[arr.length-1];
    }

    public int lcm(int a, int b) {
        return (a*b) / gcd(a,b);
    }

    public int gcd(int a, int b) {
        int r;

        while(b!=0) {
            r = a%b;
            a = b;
            b = r;
        }

        return a;
    }

}
