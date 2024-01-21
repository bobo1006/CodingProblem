import java.io.*;
        import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int s = 2000;
        int e = 0;
        int max = 0;

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            if (H > arr[max]){
                max = L;
            }
            s = Math.min(s, L);
            e = Math.max(e, L);
            arr[L] = H;
        }

        int ans = 0;
        int pre = s;
        for (int i=s+1;i<=max;i++){
            int temp = arr[i-1];

            if (temp <= arr[i]){
                ans += temp * (i-pre);
                pre = i;
            }
            else{
                arr[i] = temp;
            }
        }

        ans += arr[max];
        pre = e;
        for (int i=e-1;i>=max;i--){
            int temp = arr[i+1];

            if (temp <= arr[i]){
                ans += temp * (pre-i);
                pre = i;
            }
            else{
                arr[i] = temp;
            }
        }

        System.out.println(ans);
    }
}