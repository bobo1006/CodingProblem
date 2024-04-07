import java.io.*;
import java.util.*;

public class Main {
    static class Country{
        int x,y,val;
        Country(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N, L, R;
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 2000;

        for(int k=0;k<=2000;k++){
            boolean[][] visited = new boolean[N][N];
            boolean check = false;

            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    if (!visited[i][j]){
                        int val = bfs(i,j,visited)/list.size();
                        for (int[] d:list){
                            map[d[0]][d[1]] = val;
                        }
                        if (list.size() > 1) check = true;
                        list.clear();
                    }
                }
            }
            if (!check) {
                day = k;
                break;
            }
        }
        System.out.println(day);

    }
    private static int bfs(int x, int y, boolean[][] visited){
        Queue<Country> queue = new LinkedList<>();
        queue.add(new Country(x,y,map[x][y]));
        visited[x][y] = true;
        int total = 0;

        while (!queue.isEmpty()){
            Country now = queue.poll();
            total += now.val;
            list.add(new int[]{now.x, now.y});

            for (int i=0;i<4;i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if (!visited[nextX][nextY]){
                    int diff = Math.abs(map[nextX][nextY] - now.val);
                    if (diff >= L && diff <= R){
                        queue.add(new Country(nextX, nextY, map[nextX][nextY]));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return total;
    }
}