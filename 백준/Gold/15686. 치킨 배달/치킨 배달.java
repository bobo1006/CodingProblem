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
    static ArrayList<Point> home;
    static ArrayList<Point> store;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        home = new ArrayList<>();
        store = new ArrayList<>();

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) home.add(new Point(i,j));
                else if (map[i][j] == 2) store.add(new Point(i,j));
            }
        }
        boolean[] opened = new boolean[store.size()];
        openStore(0, opened, 0);
        System.out.println(ans);
    }

    private static void openStore(int d, boolean[] opened, int idx){
        if (d == M){
            ans = Math.min(getDistance(opened), ans);
            return;
        }
        for (int i=idx;i<opened.length;i++){
            if (!opened[i]){
                opened[i] = true;
                openStore(d+1, opened, i+1);
                opened[i] = false;
            }
        }
    }
    private static int getDistance(boolean[] opened){
        int distance = 0;

        for (Point h:home){
            int x = h.x;
            int y = h.y;
            int min = Integer.MAX_VALUE;

            for (int i=0;i<opened.length;i++){
                if (opened[i]){
                    Point s = store.get(i);
                    int d = Math.abs(x - s.x) + Math.abs(y - s.y);
                    min = Math.min(min, d);
                }
            }
            distance += min;
        }
        return distance;
    }
}