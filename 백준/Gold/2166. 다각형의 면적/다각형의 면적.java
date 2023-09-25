import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        long[][] p = new long[N+1][2];

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }
        p[N][0] = p[0][0];
        p[N][1] = p[0][1];

        System.out.println(String.format("%.1f",ccw(p, N)));
    }

    private static double ccw(long[][] p, int N){
        long m = 0;
        long n = 0;

        for (int i=0;i<N;i++){

            m += p[i][0] * p[i+1][1];
            n += p[i][1] * p[i+1][0];

        }
        double ans = Math.abs(m-n)/2.0;
        return ans;

    }
}