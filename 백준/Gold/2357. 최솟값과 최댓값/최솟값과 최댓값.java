import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int min;
        int max;

        Node(int min, int max){
            this.min = min;
            this.max = max;
        }
    }

    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] arr = new Node[N+1];
        tree = new Node[4 * N];

        for (int i=1;i<=N;i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = new Node(num, num);
        }

        init(arr, 1, 1, N);
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int min = queryMin(1, 1, N, a, b);
            int max = queryMax(1, 1, N, a, b);
            sb.append(min).append(' ').append(max).append('\n');
        }
        System.out.println(sb);

    }

    public static void init(Node[] origin, int node, int start, int end){
        if (start == end){
            tree[node] = origin[start];
            return;
        }
        int mid = (start + end) / 2;
        init(origin, node * 2, start, mid);
        init(origin, node * 2 + 1, mid + 1, end);
        tree[node] = new Node(Math.min(tree[node*2].min, tree[node*2+1].min),
                Math.max(tree[node*2].max, tree[node*2+1].max));
    }

    public static int queryMax(int node, int start, int end, int targetLeft, int targetRight){
        if (targetLeft > end || targetRight < start) return 0;
        if (targetLeft <= start && end <= targetRight){
            return tree[node].max;
        }
        int mid = (start + end) / 2;
        int lMax = queryMax(node * 2, start, mid, targetLeft, targetRight);
        int rMax = queryMax(node * 2 + 1, mid + 1, end, targetLeft, targetRight);
        return Math.max(lMax, rMax);

    }

    public static int queryMin(int node, int start, int end, int targetLeft, int targetRight){
        if (targetLeft > end || targetRight < start) return Integer.MAX_VALUE;
        if (targetLeft <= start && end <= targetRight){
            return tree[node].min;
        }
        int mid = (start + end) / 2;
        int lMin = queryMin(node * 2, start, mid, targetLeft, targetRight);
        int rMin = queryMin(node * 2 + 1, mid + 1, end, targetLeft, targetRight);
        return Math.min(lMin, rMin);

    }
}
