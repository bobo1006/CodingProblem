import java.io.*;
import java.util.*;

class Main {
    static int[] size;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        size = new int[N];
        int end = 0;
        int start = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            size[i] = Integer.parseInt(st.nextToken());
            end += size[i];
            start = Math.max(start, size[i]);
        }
        // 한편의 블루레이 크기가 최소가 되게 M개를 만든다.
        int val = 0;
        while (start <= end){
            int m = (start + end)/2;
            int cnt = count(m);

            if (cnt <= M){
                end = m - 1;
            }
            else{
                start = m + 1;
            }
        }
        System.out.println(start);
    }
    public static int count(int m){
        int sum = 0;
        int cnt = 0;
        for (int i=0;i<size.length;i++){
            if (sum + size[i] > m){
                cnt++;
                sum = 0;
            }
            sum += size[i];
        }
        if (sum != 0) cnt++;
        return cnt;
    }
}