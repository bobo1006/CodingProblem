import java.io.*;
import java.util.*;
class Main {
    static int N,M;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int max = 0;
    static ArrayList<int[]> virus;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        virus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new int[]{i,j});
            }
        }
        dfs(0);
        System.out.println(max);
    }
    public static void dfs(int cntWall){
        if (cntWall == 3){
            max = Math.max(getSafeZone(), max);
            return;
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(cntWall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    public static int getSafeZone(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for (int[] tmp:virus){
            queue.add(tmp);
            visited[tmp[0]][tmp[1]] = true;
        }
        int[][] mapClone = new int[N][M];
        for (int i=0;i<N;i++){
            mapClone[i] = map[i].clone();
        }

        while (!queue.isEmpty()){
            int[] now = queue.poll();

            for (int i=0;i<4;i++){
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (mapClone[nextX][nextY] == 0 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    mapClone[nextX][nextY] = 2;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        int cnt = 0;

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (mapClone[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}