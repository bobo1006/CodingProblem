import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        if (N != 0){
            st = new StringTokenizer(br.readLine());
        }
        for (int i=0;i<N;i++){
           arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 1;
        if (N == P && score <= arr[N-1]) ans = -1;
        else{
            for (int i=0;i<N;i++){
                int now = arr[i];
                if (score < now){
                    ans++;
                }
                else break;
            }
        }
        System.out.println(ans);


    }
}