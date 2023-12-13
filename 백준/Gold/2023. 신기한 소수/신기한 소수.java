import java.io.*;
import java.util.*;

class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[] arr = {1,2,3,5,7,9};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dfs(0,N,0);
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()){
            sb.append(pq.poll()).append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int d, int N, int num){
        if (d == N){
            if (isPrime(num)){
                pq.add(num);
            }
            return;
        }

        for (int i=0;i<arr.length;i++){
            if (d == 0 && i == 0) continue;
            if (isPrime(num * 10 + arr[i])){
                dfs(d+1, N, num*10 + arr[i]);
            }
        }
    }

    public static boolean isPrime(int num){
        for (int i=2;i<=num/2;i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}