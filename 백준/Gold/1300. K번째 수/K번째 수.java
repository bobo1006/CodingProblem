import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int start = 1;
        int end = K;
        int ans = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long cnt = count(mid, N);
            if (cnt < K){
                start = mid + 1;
            }
            else{
                end = mid - 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
    public static long count(long mid , int N){
        long cnt = 0;

        for (int i=1;i<=N;i++){
            cnt += Math.min(N, mid/i);
        }
        return cnt;
    }
}