import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int start;
        int end;
        int value;
        Node(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
        @Override
        public int compareTo(Node o){
            return this.value - o.value;
        }
    }
    static int[] parent;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int num = 1;
    static int N;
    static int M;
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<ArrayList<int[]>> island = new ArrayList<>();
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    bfs(visited, i, j, map);
                    island.add(list);
                    num++;
                }
            }
        }

        PriorityQueue<Node> priorityQueue= new PriorityQueue<>();
        for (int i=1;i<num;i++){
            for (int[] now:island.get(i-1)){
                int numIsland = map[now[0]][now[1]];
                for (int j=0;j<4;j++){
                    int nextX = now[0] + dx[j];
                    int nextY = now[1] + dy[j];
                    int d = 0;
                    while (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M){
                        if (numIsland == map[nextX][nextY]) break;
                        if (map[nextX][nextY] != 0){
                            if (d >= 2) priorityQueue.add(new Node(numIsland, map[nextX][nextY], d));
                            break;
                        }
                        else{
                            d++;
                            nextX += dx[j];
                            nextY += dy[j];
                        }
                    }
                }
            }
        }
        System.out.println(kruskal(priorityQueue));

    }
    private static int kruskal(PriorityQueue<Node> priorityQueue){
        parent = new int[num];
        for (int i=0;i<num;i++){
            parent[i] = i;
        }
        int value = 0;
        int used = 0;
        while (!priorityQueue.isEmpty()){
            Node node = priorityQueue.poll();
            int a = find(node.start);
            int b = find(node.end);
            if (a != b){
                union(a,b);
                value += node.value;
                used++;
            }
        }
        if (used != num - 2) value = -1;
        return value;
    }

    private static void bfs(boolean[][] visited, int x, int y, int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        list = new ArrayList<>();
        list.add(new int[]{x,y});
        visited[x][y] = true;
        map[x][y] = num;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (!visited[nextX][nextY] && map[nextX][nextY] != 0) {
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = num;
                    int[] temp = {nextX, nextY};
                    queue.add(temp);
                    list.add(temp);
                }
            }
        }
    }

    private static int find(int a) {
        if (a == parent[a]) return a;

        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b){
            parent[a] = b;
        }
        else parent[b] = a;
    }
}