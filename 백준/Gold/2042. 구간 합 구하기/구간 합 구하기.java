import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        long[] arr = new long[N+1];
        for (int i=1;i<=N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[4*N];
        buildTree(arr, 1, 1, N);

        for (int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1){
                long diff = c - arr[b];
                arr[b] = c;
                update(b, 1, 1, N, diff);
            }
            else{
                sb.append(query(1 , b, c, 1, N)).append('\n');
            }

        }
        System.out.println(sb);
    }

    public static void buildTree(long[] origin, int node, int start, int end){
        if (start == end){
            tree[node] = origin[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(origin, node * 2, start, mid);
        buildTree(origin, node * 2 + 1, mid + 1, end);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static long query(int node, int targetLeft, long targetRight, int start, int end){
        if (end < targetLeft || targetRight < start) return 0;
        if (targetLeft <= start && end <= targetRight){
            return tree[node];
        }
        int mid = (start + end) / 2;
        long lSum = query(node * 2, targetLeft, targetRight, start, mid);
        long rSum = query(node * 2+ 1, targetLeft, targetRight, mid + 1, end);

        return lSum + rSum;
    }
    public static void update(int index, int node, int start, int end, long diff){
        if (start > index || index > end){
            return;
        }
        tree[node] += diff;

        if (start == end){
            return;
        }
        int mid = (start + end) / 2;
        update(index, node * 2, start, mid, diff);
        update(index, node * 2 + 1, mid + 1, end, diff);

    }
}
