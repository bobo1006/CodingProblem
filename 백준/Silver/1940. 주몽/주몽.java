import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start = 0;
        int end = N-1;
        int cnt = 0;

        while (start < end){
            int a = arr[start];
            int b = arr[end];

            if (a+b == M){
                cnt++;
                start++;
                end--;
            }
            if (a+b < M){
                start++;
            }
            if (a+b > M){
                end--;
            }
        }
        System.out.println(cnt);
    }
}