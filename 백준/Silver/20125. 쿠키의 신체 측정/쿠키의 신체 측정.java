import java.io.*;
import java.util.*;

class Main {
    static char[][] map;
    static int x;
    static int y;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i=0;i<N;i++){
            map[i] = br.readLine().toCharArray();
        }
        getHeart(N);
        sb.append(x+1).append(" ").append(y+1).append('\n');

        getLenArm();
        x += getLenBack();
        getLenLeg(-1);
        getLenLeg(1);

        System.out.println(sb);
    }

    public static void getHeart(int N) {
        for (int i = 0; i< N; i++){
            for (int j = 0; j< N; j++){
                if (map[i][j] == '*'){
                    x = i+1;
                    y = j;
                    return;
                }
            }
        }
    }
    public static int getLenBack(){
        int len = 0;
        for (int i=x+1;i<N;i++){
            if (map[i][y] != '*'){
                break;
            }
            len++;
        }
        sb.append(len).append(" ");
        return len;
    }
    public static void getLenLeg(int temp){
        int len = 0;

        for (int i=x+1;i<N;i++){
            if (map[i][y+temp] != '*'){
                break;
            }
            len++;
        }
        sb.append(len).append(" ");
    }
    public static void getLenArm(){
        int len = 0;
        for (int i=y-1;i>=0;i--){
            if (map[x][i] != '*'){
                break;
            }
            len++;
        }
        sb.append(len).append(" ");

        len = 0;

        for (int i=y+1;i<N;i++){
            if (map[x][i] != '*'){
                break;
            }
            len++;
        }
        sb.append(len).append(" ");
    }
}