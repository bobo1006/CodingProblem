import java.io.*;
import java.util.*;

class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];

        for (int i=0;i<N;i++){
            list.add(new ArrayList<>());
        }

        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            list.get(e1).add(e2);
            list.get(e2).add(e1);
        }

        for (int i=0;i<N;i++){
            visited[i] = true;
            dfs(1,i);
            visited[i] = false;
            if (ans == 1) break;
        }
        System.out.println(ans);
    }
    public static void dfs(int d, int s){
        if (d == 5){
            ans = 1;
            return;
        }

        for (int i:list.get(s)){
            if (!visited[i]){
                visited[i] = true;
                dfs(d+1,i);
                visited[i] = false;
            }
        }
    }
}