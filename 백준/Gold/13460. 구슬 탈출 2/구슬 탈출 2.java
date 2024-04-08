import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Balls{
        Point red;
        Point blue;
        int cnt;
        Balls(Point red, Point blue, int cnt){
            this.red = red;
            this.blue = blue;
            this.cnt = cnt;
        }
    }
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static char[][] map;
    static int N,M;
    static boolean redGoal;
    static boolean blueGoal;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Point red = null;
        Point blue = null;

        map = new char[N][M];
        for (int i=0;i<N;i++){
            String s = br.readLine();
            for (int j=0;j<M;j++){
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'R'){
                    red = new Point(i,j);
                }
                else if (map[i][j] == 'B'){
                    blue = new Point(i,j);
                }
            }
        }
        int answer = bfs(red,blue);
        if (answer > 10) answer = -1;
        System.out.println(answer);
    }
    private static void setLocation(Point nowRed, Point nowBlue, Point nextRed, Point nextBlue, int d){

        if (nowRed.x < nowBlue.x){
            if (d == 1) nextBlue.x += 1;
            else nextRed.x -= 1;
        }
        else if (nowRed.y < nowBlue.y){
            if (d == 3) nextBlue.y += 1;
            else nextRed.y -= 1;
        }
        else if (nowRed.x > nowBlue.x){
            if (d == 1) nextRed.x += 1;
            else nextBlue.x -= 1;
        }
        else if (nowRed.y > nowBlue.y){
            if (d == 3) nextRed.y += 1;
            else nextBlue.y -= 1;
        }

    }
    private static int bfs(Point red, Point blue){
        Queue<Balls> queue = new LinkedList<>();
        queue.add(new Balls(red, blue, 0));
        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[red.x][red.y][blue.x][blue.y] = true;
        int cnt = -1;

        while (!queue.isEmpty()){
            Balls now = queue.poll();
            Point nowRed = now.red;
            Point nowBlue = now.blue;

            for (int i=0;i<4;i++){
                redGoal = false;
                blueGoal = false;

                Point nextRed = getNext(nowRed, 0, i);
                Point nextBlue = getNext(nowBlue, 1, i);
                if (blueGoal) continue;
                if (redGoal) return now.cnt+1;
                
                if (nextRed.x == nextBlue.x && nextRed.y == nextBlue.y){
                    setLocation(nowRed, nowBlue, nextRed, nextBlue, i);
                }
                if (visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y]) continue;

                visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y] = true;
                queue.add(new Balls(nextRed, nextBlue, now.cnt+1));
            }
        }
        return cnt;
    }

    private static Point getNext(Point point, int color, int d) {
        int nextX = point.x;
        int nextY = point.y;

        while (true){
            nextX += dir[d][0];
            nextY += dir[d][1];
            if (checkGoal(nextX, nextY, color)){
                break;
            }
            if(checkWall(nextX, nextY)){
                nextX -= dir[d][0];
                nextY -= dir[d][1];
                break;
            }
        }
        return new Point(nextX, nextY);

    }
    private static boolean checkWall(int x, int y){
        if (x <= 0 || y <= 0 || x >= N-1 || y >= M-1) return true;
        if (map[x][y] == '#') return true;
        return false;
    }
    private static boolean checkGoal(int x, int y, int color){
        if (map[x][y] == 'O'){
            if (color == 0) redGoal = true;
            else blueGoal = true;
            return true;
        }
        return false;
    }
}