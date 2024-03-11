import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] gear = new int[5][8];

        for (int i=1;i<=4;i++){
            String s = br.readLine();
            for (int j=0;j<8;j++){
                gear[i][j] = s.charAt(j) - '0';
            }
        }
        int K = Integer.parseInt(br.readLine());
        for (int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[4];
            turn(gear, n, t, visited);
        }

        int ans = gear[1][0] + (gear[2][0] * 2) + (gear[3][0] * 4) + (gear[4][0] * 8);
        System.out.println(ans);
    }
    public static void turn(int[][] gear, int n, int t, boolean[] visited){

        if (visited[n-1]) return;
        visited[n-1] = true;

        if (n != 4 && gear[n][2] != gear[n+1][6]){
            turn(gear, n+1, t * -1, visited);
        }
        if (n != 1 && gear[n][6] != gear[n-1][2]){
            turn(gear, n-1, t * -1, visited);
        }

        if (t == 1){
            int temp = gear[n][0];
            gear[n][0] = gear[n][7];
            gear[n][7] = gear[n][6];
            gear[n][6] = gear[n][5];
            gear[n][5] = gear[n][4];
            gear[n][4] = gear[n][3];
            gear[n][3] = gear[n][2];
            gear[n][2] = gear[n][1];
            gear[n][1] = temp;
        }
        else if (t == -1){
            int temp = gear[n][0];
            gear[n][0] = gear[n][1];
            gear[n][1] = gear[n][2];
            gear[n][2] = gear[n][3];
            gear[n][3] = gear[n][4];
            gear[n][4] = gear[n][5];
            gear[n][5] = gear[n][6];
            gear[n][6] = gear[n][7];
            gear[n][7] = temp;
        }

    }
}