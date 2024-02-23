import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 1;
        int e = N;
        int ans = 0;

        while (s <= e){
            int mid = (s+e)/2;

            if (!check(N,mid,arr)){
                s = mid+1;
            }
            else{
                e = mid-1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }

    public static boolean check(int N, int h, int[] arr){
        int start = 0;

        for (int i=0;i<arr.length;i++){
            int temp = arr[i];
            if(start < temp - h){
                return false;
            }
            start = temp + h;
        }

        if (start < N) return false;
        return true;
    }
}