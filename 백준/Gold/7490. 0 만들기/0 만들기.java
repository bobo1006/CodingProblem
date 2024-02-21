import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0;i<T;i++){
            N = Integer.parseInt(br.readLine());
            dfs(1, 0, 1, 1, "1");
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int idx, int sum, int num, int sign, String s){
        if (idx == N){
            if (sum + (num * sign) == 0){
                sb.append(s).append('\n');
            }
            return;
        }
        dfs(idx+1, sum, num * 10 + idx+1, sign, s + " " + String.valueOf(idx+1));
        dfs(idx+1, sum + (num*sign), idx+1, 1, s + "+" + String.valueOf(idx+1));
        dfs(idx+1, sum + (num*sign), idx+1, -1, s + "-" + String.valueOf(idx+1));


    }
}