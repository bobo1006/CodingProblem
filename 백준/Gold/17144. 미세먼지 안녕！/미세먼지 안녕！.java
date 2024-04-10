import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static ArrayList<Point> dust = new ArrayList<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int R,C;
    static Point airCleaner = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());


        map = new int[R][C];

        for (int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<C;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0){
                    dust.add(new Point(i,j));
                }
                else if (map[i][j] == -1 && airCleaner == null) airCleaner = new Point(i,j);
            }
        }

        System.out.println(solution(T));

    }
    private static int solution(int T){
        for (int i=0;i<T;i++){
            int[][] mapTemp = new int[R][C];
            for (int x=0;x<R;x++){
                for (int y=0;y<C;y++){
                    if (map[x][y] > 0){
                        spread(x,y, mapTemp);
                    }
                }
            }
            copy(mapTemp);
            map[airCleaner.x][0] = -1;
            map[airCleaner.x+1][0] = -1;
            rotation();
            rotationReverse();
        }

        return getTotal();
    }
    private static void copy(int[][] mapTemp){
        for (int i=0;i<R;i++){
            map[i] = mapTemp[i].clone();
        }
    }
    private static int getTotal(){
        int total = 2;
        for (int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                total += map[i][j];
            }
        }
        return total;
    }
    private static void spread(int x, int y, int[][] mapTemp){
        int cnt = 0;
        int temp = map[x][y] / 5;

        for (int i=0;i<4;i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;
            if (map[nextX][nextY] != -1){
                mapTemp[nextX][nextY] += temp;
                cnt++;
            }
        }
        mapTemp[x][y] += map[x][y]- (cnt * temp);
    }

    private static void rotationReverse(){
        int x = airCleaner.x;
        int y = airCleaner.y;

        for (int i=x-1;i>0;i--){
            map[i][0]= map[i-1][0];
        }
        for (int i=0;i<C-1;i++){
            map[0][i] = map[0][i+1];
        }
        for (int i=0;i<x;i++){
            map[i][C-1]= map[i+1][C-1];
        }
        for (int i=C-1;i>1;i--){
            map[x][i] = map[x][i-1];
        }
        map[x][y+1] = 0;
    }
    private static void rotation(){
        int x = airCleaner.x + 1;
        int y = airCleaner.y;

        for (int i=x+1;i<R-1;i++){
            map[i][0] = map[i+1][0];
        }

        for (int i=0;i<C-1;i++){
            map[R-1][i] = map[R-1][i+1];
        }

        for (int i=R-1;i>x;i--){
            map[i][C-1] = map[i-1][C-1];
        }

        for (int i=C-1;i>1;i--){
            map[x][i] = map[x][i-1];
        }
        map[x][y+1] = 0;
    }
}