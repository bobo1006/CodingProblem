import java.io.*;
import java.util.*;
class Dice{
    int top = 0 , bottom = 0, left = 0, right = 0, face = 0, back = 0;
    void move(int d){
        switch (d){
            case 1:
                moveRight();
                break;
            case 2:
                moveLeft();
                break;
            case 3:
                moveUp();
                break;
            case 4:
                moveDown();
                break;
        }
    }
    private void moveRight(){
        int temp = top;
        top = left;
        left = bottom;
        bottom = right;
        right = temp;

    }
    private void moveLeft(){
        int temp = top;
        top = right;
        right = bottom;
        bottom = left;
        left = temp;
    }
    private void moveUp(){
        int temp = top;
        top = face;
        face = bottom;
        bottom = back;
        back = temp;
    }
    private void moveDown(){
        int temp = top;
        top = back;
        back = bottom;
        bottom = face;
        face = temp;
    }

}
class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Dice dice = new Dice();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<K;i++) {
            int d = Integer.parseInt(st.nextToken());
            int nextX = x + dx[d-1];
            int nextY = y + dy[d-1];
            if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;

            dice.move(d);

            if (map[nextY][nextX] == 0){
                map[nextY][nextX] = dice.bottom;
            }
            else{
                dice.bottom = map[nextY][nextX];
                map[nextY][nextX] = 0;
            }
            y = nextY;
            x = nextX;
            sb.append(dice.top).append('\n');
        }
        System.out.println(sb);

    }
}