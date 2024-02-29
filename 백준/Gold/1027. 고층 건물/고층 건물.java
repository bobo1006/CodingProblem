import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }
        int ans = 0;

        for (int i=0;i<N;i++){
            ans = Math.max(getCnt(arr, i), ans);
        }

        System.out.println(ans);

    }

    private static int getCnt(int[] arr, int idx) {
        double slo = 1000000001;
        int cnt = 0;

        for (int i = idx -1; i>=0; i--){
             double now = (double)(arr[idx] - arr[i]) / (idx - i);
             if (slo > now){
                 cnt++;
                 slo = now;
             }
        }
        slo = -1000000001;

        for (int i = idx +1; i<arr.length; i++){
            double now = (double)(arr[idx] - arr[i]) / (idx - i);
            if (slo < now){
                cnt++;
                slo = now;
            }
        }
        return cnt;
    }
}