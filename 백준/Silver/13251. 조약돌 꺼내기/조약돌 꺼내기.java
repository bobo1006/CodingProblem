import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        int total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        int K = Integer.parseInt(br.readLine());
        double ans = 0.0;

        for (int i=0;i<M;i++){
            if (arr[i] >= K){
                double temp = 1.0;

                for (int j=0;j<K;j++){
                    temp *= (double)(arr[i]-j) / (total-j);
                }
                ans += temp;
            }
        }
        System.out.println(ans);
    }
}