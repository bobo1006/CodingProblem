import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int value;
        int node;
        Node(int node, int value){
            this.node = node;
            this.value = value;
        }
    }
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static int N,M,start,end;
    static final long MIN = Long.MIN_VALUE;
    static final long MAX = Long.MAX_VALUE;
    static long[] total;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        total = new long[N];

        for (int i=0;i<N;i++){
            list.add(new ArrayList<>());
            total[i] = MIN;
        }
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,v));
        }

        long[] money = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            money[i] = Integer.parseInt(st.nextToken());
        }
        total[start] = money[start];
        bellman(money);

        if (total[end] == MAX){
            System.out.println("Gee");
        }
        else if (total[end] == MIN){
            System.out.println("gg");
        }
        else{
            System.out.println(total[end]);
        }
    }

    private static void bellman(long[] money){
        for (int i=0;i<=N+100;i++){
            for (int j=0;j<N;j++){
                for (Node n:list.get(j)){
                    if (total[j] == MIN) break;
                    else if (total[j] == MAX){
                        total[n.node] = MAX;
                        continue;
                    }
                    if (total[n.node] < total[j] + money[n.node] - n.value){
                        total[n.node] = total[j] + money[n.node] - n.value;
                        if (i >= N-1) total[n.node] = MAX;
                    }
                }
            }
        }

    }
}