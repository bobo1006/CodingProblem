import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int x,y;
        int value;

        Point(int  x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    static int[][] plate;
    static int N,M;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        plate = new int[N][M];

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++){
                plate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (int j=x-1;j<N;j+=x){
                turn(j, d, k);
            }
            if (!deleteNum()){
                changeNum();
            }
        }
        int total = 0;
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (plate[i][j] == 0) continue;
                total += plate[i][j];
            }
        }
        System.out.println(total);
    }

    private static void turn(int num, int d, int k){
        if (k == M) return;
        int[] plateClone = plate[num].clone();

        if (d == 0){
            for (int i=M-1;i>=0;i--){
                int dir = (i + M - k) % M;
                plate[num][i] = plateClone[dir];
            }
        }
        else{
            for (int i=0;i<M;i++){
                int dir = (i + M + k) % M;
                plate[num][i] = plateClone[dir];
            }
        }
    }
    private static boolean deleteNum(){
        boolean flag = false;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (visited[i][j] || plate[i][j] == 0) continue;
                queue.add(new Point(i,j,plate[i][j]));

                while (!queue.isEmpty()){
                    Point now = queue.poll();

                    for (int k=0;k<4;k++){
                        int nextX = now.x + dx[k];
                        int nextY = now.y + dy[k];
                        if (nextX < 0 || nextX >= N) continue;

                        if (nextY == M) nextY = 0;
                        else if (nextY == -1) nextY = M-1;

                        if (!visited[nextX][nextY] && plate[nextX][nextY] == now.value){
                            queue.add(new Point(nextX, nextY, plate[nextX][nextY]));
                            plate[nextX][nextY] = 0;
                            plate[now.x][now.y] = 0;
                            visited[nextX][nextY] = true;
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;

    }
    private static double getAver(){
        double total = 0;
        double cnt = 0;
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (plate[i][j] != 0){
                    total += plate[i][j];
                    cnt++;
                }
            }
        }
        return total/cnt;
    }
    private static void changeNum(){
        double avg = getAver();

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (plate[i][j] == 0) continue;
                if (plate[i][j] < avg) plate[i][j]++;
                else if (plate[i][j] > avg) plate[i][j] --;
            }
        }
    }
}