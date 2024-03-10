import java.io.*;
import java.util.*;
class Main {
    static int[][] arr;
    static int N;
    static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][2];

        for (int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i][0] = t;
            arr[i][1] = p;
        }

        getMax(1, 0);
        System.out.println(max);
    }
    public static void getMax(int day, int sum){
        for (int i=day;i<=N;i++){
            if (i + arr[i][0] > N + 1) continue;
            max = Math.max(max, sum + arr[i][1]);
            getMax(i + arr[i][0] , sum + arr[i][1]);
        }
    }
}