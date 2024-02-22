import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        int[] target = new int[N];

       String s = br.readLine();
        for (int i=0;i<s.length();i++){
            arr1[i] = s.charAt(i) - '0';
        }
        arr2 = Arrays.copyOf(arr1,N);
        arr2[0] = 1 - arr2[0];
        arr2[1] = 1 - arr2[1];

        s = br.readLine();
        for (int i=0;i<s.length();i++){
            target[i] = s.charAt(i) -'0';
        }

        int ans1 = change(arr1, target, N);
        int ans2 = change(arr2, target, N);

        if (ans1 == -2){
            System.out.println(ans2 + 1);
        }
        else if (ans2 == -2){
            System.out.println(ans1);
        }
        else{
            System.out.println(Math.min(ans1, 1 + ans2));
        }
    }
    public static int change(int[] arr, int[] target, int N){
        int cnt = 0;

        for (int i=1;i<N;i++){
            if (target[i-1] != arr[i-1]){
                arr[i-1] = 1 - arr[i-1];
                arr[i] = 1 - arr[i];
                if (i != N-1){
                    arr[i+1] = 1 - arr[i+1];
                }
                cnt++;
            }
        }

        if (target[N-1] != arr[N-1]) cnt = -2;
        return cnt;
    }
}