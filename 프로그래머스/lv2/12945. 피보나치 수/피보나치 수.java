import java.util.HashMap;

class Solution {
    static int[] arr;
    public int solution(int n) {
        arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        int answer = fibo(n);
        return answer;
    }

    private int fibo(int n){
        if (n == 0){
            return 0;
        }
        else if (arr[n] != 0){
            return arr[n];
        }

        return arr[n] = (fibo(n-1) + fibo(n-2)) % 1234567;
    }
}