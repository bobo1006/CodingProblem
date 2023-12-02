import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start = 1;
        int end = 1;
        int cnt = 1;
        int sum = 1;

        while (end < N){
            if (sum == N){
                cnt++;
                end++;
                sum += end;
            } else if (sum < N) {
                end++;
                sum += end;
            } else if (sum > N) {
                sum -= start;
                start++;
            }
        }
        System.out.println(cnt);

    }
}