import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] p = new int[3][2];

        for (int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(ccw(p));
    }

    private static int ccw(int[][] p){
        int m = p[0][0] * p[1][1] + p[1][0] * p[2][1] + p[2][0] * p[0][1];
        int n = p[0][1] * p[1][0] + p[1][1] * p[2][0] + p[2][1] * p[0][0];

        if (m - n == 0){
            return 0;
        }
        else if (m - n > 0){
            return 1;
        }

        return -1;

    }
}