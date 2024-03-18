import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            long sum = 0;
            int[] arr = new int[N];
            int max = N-1;
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j=N-2;j>=0;j--){
                if (arr[max] < arr[j]){
                    max = j;
                }
                else{
                    sum += arr[max] - arr[j];
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}