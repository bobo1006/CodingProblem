import java.io.*;
import java.util.*;

public class Main {
    static class Road implements Comparable<Road>{
        int end;
        int value;
        Road(int end, int value){
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Road o) {
            return this.value - o.value;
        }
    }
    static int D;
    static ArrayList<ArrayList<Road>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int[] dist = new int[D+2];
        for (int i=0;i<=D;i++){
            dist[i] = i;
        }

        for (int i=0;i<=D;i++){
            list.add(new ArrayList<>());
        }
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (s >= D) continue;
            list.get(s).add(new Road(e,v));
        }

        for (int i=0;i<=D;i++){
            for (Road r:list.get(i)){
                if (r.end > D) continue;
                dist[r.end] = Math.min(dist[i] + r.value, dist[r.end]);
            }
            dist[i+1] = Math.min(dist[i] + 1, dist[i+1]);
        }

        System.out.println(dist[D]);
    }
}