import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        for (int i=1;i<=N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[N*4];
        init(1, N, 1);

        for (int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1){
                long num = c - arr[b];
                arr[b] = c;
                change(1,N,num,1,b);
            }
            else{
                sb.append(sum(1,N,1,b,(int)c)).append('\n');
            }
        }
        System.out.println(sb);

    }
    private static long init(int start, int end, int node){
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2)
                + init(mid+1, end, node * 2 + 1);
    }

    private static long sum(int start, int end, int node, int left, int right){
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return sum(start , mid, node*2, left, right)
                + sum(mid+1, end, node*2+1, left, right);
    }

    private static void change(int start, int end, long diff, int node, int index){
        if (index > end || index < start) return ;
        tree[node] += diff;

        if (start == end) return;

        int mid = (start+end)/2;
        change(start, mid, diff, node*2, index);
        change(mid+1, end, diff, node*2+1, index);
    }
}