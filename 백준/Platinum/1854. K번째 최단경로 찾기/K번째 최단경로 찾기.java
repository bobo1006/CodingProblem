import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int value;
        int node;
        Node(int node, int value){
            this.node = node;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value < o.value ? -1:1;
        }
    }
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static PriorityQueue<Integer>[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        for (int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,c));
        }
        dijk(n,m,k);
        StringBuilder sb = new StringBuilder();
        for (int i=1;i<=n;i++){
            if (dist[i].size() == k){
                sb.append(dist[i].peek());
            }
            else sb.append(-1);
            sb.append('\n');
        }
        System.out.println(sb);
    }
    private static void dijk(int n, int m, int k){
        dist = new PriorityQueue[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i=0;i<n+1;i++){
            dist[i] = new PriorityQueue<>(Collections.reverseOrder());
        }
        pq.add(new Node(1,0));
        dist[1].add(0);

        while (!pq.isEmpty()){
            Node now = pq.poll();

            for (Node next:list.get(now.node)){
                int val = next.value + now.value;

                if (dist[next.node].size() < k){
                    dist[next.node].add(val);
                    pq.add(new Node(next.node, val));
                }
                else if (dist[next.node].peek() > val){
                    dist[next.node].add(val);
                    pq.add(new Node(next.node, val));
                    dist[next.node].poll();
                }
            }
        }
    }

}