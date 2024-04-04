import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int value;
        Edge(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
        @Override
        public int compareTo(Edge o){
            return this.value - o.value;
        }
    }
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int total = 0;

        parent = new int[N];
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        for (int i=0;i<N;i++){
            String s = br.readLine();
            for (int j=0;j<s.length();j++){
                char c = s.charAt(j);
                int val;

                if (c == '0') continue;
                if ('a' <= c) val = c - 'a' + 1;
                else val = c - 'A' + 27;

                priorityQueue.add(new Edge(i,j,val));
                total += val;
            }
            parent[i] = i;
        }

        int used = 0;

        while (!priorityQueue.isEmpty()){
            Edge now = priorityQueue.poll();
            if (find(now.start) != find(now.end)){
                union(now.start,now.end);
                total -= now.value;
                used++;
            }
        }

        if (used != N-1) total = -1;
        System.out.println(total);



    }
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a < b){
            parent[b] = a;
        }
        else parent[a] = b;
    }
    private static int find(int a){
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
}