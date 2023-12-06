import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;

        for (int i=0;i<N;i++){
            int K = arr[i];
            int s = 0;
            int e = N-1;

            while (s < e){
                int sum = arr[s] + arr[e];

                if (sum == K){
                    if (i != s && i != e){
                        cnt++;
                        break;
                    }
                    if (i == s) s++;
                    if (i == e) e--;
                }
                if (sum < K){
                    s++;
                }
                if (sum > K){
                    e--;
                }
            }
        }
        System.out.println(cnt);

    }
}