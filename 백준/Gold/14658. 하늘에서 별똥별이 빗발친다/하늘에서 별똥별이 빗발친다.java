import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[K][2];

        for (int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int min = K;

        for (int i=0;i<K;i++){
            for (int j=0;j<K;j++){
                int startX = arr[i][0];
                int startY = arr[j][1];
                int endX = startX + L;
                int endY = startY + L;
                int cnt = 0;
                for (int n=0;n<K;n++) {
                    if (startX > arr[n][0] || arr[n][0] > endX || startY > arr[n][1] || arr[n][1] > endY){
                        cnt++;
                    }
                }
                min = Math.min(cnt,min);
            }
        }
        System.out.println(min);
    }
}
