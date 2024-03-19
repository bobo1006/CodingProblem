import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] cnt = new int[100001];
        int p1 = 0;
        int max = 0;
        int len = 0;
        for (int i=0;i<N;i++){
            cnt[arr[i]]++;
            while (cnt[arr[i]] > K && p1 < i){
                cnt[arr[p1]]--;
                p1++;

            }
            len = i+1 - p1;
            max = Math.max(max, len);
        }
        System.out.println(max);
    }
}