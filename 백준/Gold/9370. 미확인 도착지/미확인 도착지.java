import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int num;
        int val;
        Node(int num, int val){
            this.num = num;
            this.val = val;
        }
        @Override
        public int compareTo(Node o){
            return this.val - o.val;
        }
    }
    static ArrayList<ArrayList<Node>> edges;
    static int n;
    static int distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<T;i++){
            ArrayList<Integer> answerList = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            for (int j=0;j<n+1;j++){
                edges.add(new ArrayList<>());
            }

            for (int j=0;j<m;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                if ((a == g && b == h) || (a == h && b == g)){
                    distance = d;
                }
                edges.get(a).add(new Node(b,d));
                edges.get(b).add(new Node(a,d));
            }

            int[] distBase = dijk(s);
            int[] distG = dijk(g);
            int[] distH = dijk(h);

            for (int j=0;j<t;j++){
                int x = Integer.parseInt(br.readLine());
                int route1 = distBase[g] + distance + distH[x];
                int route2 = distBase[h] + distance + distG[x];
                int route3 = distBase[x];

                if (Math.min(route1, route2) == route3){
                    answerList.add(x);
                }
            }
            Collections.sort(answerList);
            for (int num:answerList){
                sb.append(num + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    private static int[] dijk(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, 100000000);
        dist[start] = 0;
        pq.add(new Node(start, 0));
        boolean[] visited = new boolean[n+1];

        while (!pq.isEmpty()){
            Node now = pq.poll();

            visited[now.num] = true;

            for (Node node: edges.get(now.num)){
                if (visited[node.num]) continue;
                if (node.val + now.val < dist[node.num]){
                    dist[node.num] = node.val + now.val;
                    pq.add(new Node(node.num, dist[node.num]));
                }
            }
        }
        return dist;
    }
}