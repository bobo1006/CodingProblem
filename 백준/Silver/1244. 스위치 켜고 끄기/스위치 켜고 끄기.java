import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];

        for (int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            change(arr, sex, num);
        }
        StringBuilder sb = new StringBuilder();
        int l = 20;
        for (int i=1;i<=N;i++){
            sb.append(arr[i]).append(" ");
            if (i == l){
                sb.append('\n');
                l += 20;
            }
        }
        System.out.println(sb);
    }
    public static void change(int[] arr, int sex, int num){
        if (sex == 1){
            for (int i=num;i<arr.length;i+=num){
                arr[i] = Math.abs(arr[i] - 1);
            }
        }
        if (sex == 2){
            int start = num-1;
            int end = num+1;

            while (true){
                if (start < 1 || end > arr.length-1)break;
                if (arr[start] != arr[end]) break;
                start--;
                end++;
            }

            for (int i=start+1;i<=end-1;i++){
                arr[i] = Math.abs(arr[i]-1);
            }
        }
    }

}
