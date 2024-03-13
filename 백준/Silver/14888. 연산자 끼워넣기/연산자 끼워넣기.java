import java.io.*;
import java.util.*;
class Main {
    static int N;
    static int[] arr;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<4;i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }
    public static void dfs(int d, int num){
        if (d == N-1){
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }

        for (int i=0;i<4;i++){
            if (operator[i] > 0){
                operator[i]--;
                dfs(d+1, calc(i,num,arr[d+1]));
                operator[i]++;
            }
        }
    }

    public static int calc(int op, int a, int b){
        switch (op){
            case 0:
                a += b;
                break;
            case 1:
                a -= b;
                break;
            case 2:
                a *= b;
                break;
            case 3:
                a /= b;
                break;
        }
        return a;
    }
}