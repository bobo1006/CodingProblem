import java.io.*;
import java.util.*;
class Main {
    static class Cctv{
        int x,y;
        int val;
        Cctv(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static ArrayList<Cctv> list;
    static int N, M;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5){
                    list.add(new Cctv(i,j,map[i][j]));
                }
            }
        }
        int[] setting = new int[list.size()];
        boolean[] used = new boolean[list.size()];
        setCctv(0, setting);
        System.out.println(min);
    }
    private static void setCctv(int d, int[] setting){
        if (d == setting.length){
            min = Math.min(getCnt(setting), min);
            return;
        }

        for (int j=0;j<4;j++){
            setting[d] = j;
            setCctv(d+1, setting);
        }
    }
    private static int getCnt(int[] setting){
        Queue<Cctv> queue = new LinkedList<>();
        queue.addAll(list);
        int idx = 0;

        int[][] mapClone = new int[N][M];
        for (int i=0;i<N;i++){
            mapClone[i] = map[i].clone();
        }

        while (!queue.isEmpty()){
            Cctv now = queue.poll();
            mapClone[now.x][now.y] = 7;
            cctvVal(now,setting[idx],mapClone);
            idx++;
        }
        int cnt = 0;

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (mapClone[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
    private static void cctvVal(Cctv now, int dir, int[][] mapClone){
        if (now.val == 5) {
            checkSpot((dir + 1) % 4, now.x, now.y, mapClone);
        }
        if (now.val >= 3) {
            checkSpot((dir + 3) % 4, now.x, now.y, mapClone);
        }
        if (now.val != 3 && now.val != 1) {
            checkSpot((dir + 2) % 4, now.x, now.y, mapClone);
        }
        checkSpot(dir, now.x, now.y, mapClone);
    }
    private static boolean isWallOrOut(int nextX, int nextY, int[][] mapClone){
        return nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || mapClone[nextX][nextY] == 6;

    }
    private static void checkSpot(int dir, int x, int y, int[][] mapClone){
        int nextX = x + dx[dir];
        int nextY = y + dy[dir];

        while (!isWallOrOut(nextX,nextY,mapClone)){
            mapClone[nextX][nextY] = 7;
            nextX += dx[dir];
            nextY += dy[dir];
        }
    }
}