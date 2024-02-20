import java.io.*;
import java.util.*;

class Main {
    static boolean[][] num= {{true, true, true, true, true, true,false},
                            {false, true, true,false,false,false,false},
                            {true, true,false, true, true,false, true},
                            {true, true, true, true,false,false, true},
                            {false, true, true,false,false, true, true},
                            {true,false, true, true,false, true, true},
                            {true,false, true, true, true, true, true},
                            {true, true, true,false,false,false,false},
                            {true, true, true, true, true, true, true},
                            {true, true, true, true,false, true, true}
                            };
    static int N;
    static int K;
    static int P;
    static int X;
    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int[] arrX = change(X);
        check(arrX);
        System.out.println(ans);
    }
    public static void check(int[] arrX){
        for (int i=1;i<=N;i++){
            if (i == X) continue;
            int[] target = change(i);
            if (reverse(target , arrX)){
                ans++;
            }
        }
    }
    public static int[] change(int n){
        int[] arr = new int[K];

        for (int i=K-1;i>=0;i--){
            int m = n % 10;
            arr[i] = m;
            n /= 10;
        }
        return arr;
    }
    public static boolean reverse(int[] target, int[] arrX){
        int cnt = 0;
        for (int i=0;i<K;i++){
            for (int j=0;j<7;j++){
                if (num[target[i]][j] != num[arrX[i]][j]){
                    cnt++;
                }
                if (cnt > P) return false;
            }
        }
        return true;
    }
}