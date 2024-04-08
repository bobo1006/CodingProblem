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
    static boolean redGoal = false;
    static boolean blueGoal = false;
    static int answer = Integer.MAX_VALUE;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static char[][] map;
    static int N,M;

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

        dfs(red, blue, 0);
        if (answer == Integer.MAX_VALUE) answer = -1;
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
    private static void dfs(Point nowRed, Point nowBlue, int cnt){
        if (cnt > 10 || cnt >= answer || blueGoal) return;

        if (redGoal){
            answer = Math.min(cnt, answer);
            return;
        }

        for (int i=0;i<4;i++){
            boolean temp1 = redGoal;
            boolean temp2 = blueGoal;

            Point nextRed = getNext(nowRed, 0, i);
            Point nextBlue = getNext(nowBlue, 1, i);


            if (nextRed.x == nextBlue.x && nextRed.y == nextBlue.y){
                setLocation(nowRed, nowBlue, nextRed, nextBlue, i);
            }
            dfs(nextRed, nextBlue, cnt+1);
            redGoal = temp1;
            blueGoal = temp2;
        }
    }

    private static Point getNext(Point point, int color, int d) {
        int nextX = point.x;
        int nextY = point.y;

        while (true){
            nextX += dir[d][0];
            nextY += dir[d][1];
            if(checkWallOrGoal(nextX, nextY, color)){
                nextX -= dir[d][0];
                nextY -= dir[d][1];
                break;
            }
        }
        return new Point(nextX, nextY);

    }
    private static boolean checkWallOrGoal(int x, int y, int color){
        if (x <= 0 || y <= 0 || x >= N-1 || y >= M-1) return true;
        if (map[x][y] == '#') return true;
        if (map[x][y] == 'O'){
            if (color == 0) redGoal = true;
            else blueGoal = true;
            return true;
        }
        return false;
    }
}