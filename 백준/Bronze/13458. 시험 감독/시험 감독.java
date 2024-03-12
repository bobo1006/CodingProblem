import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long cnt = N;
        for (int i=0;i<N;i++){
            people[i] -= B;
            if (people[i] > 0) {
                cnt += (people[i] % C == 0) ? people[i] / C : people[i] / C + 1;
            }
        }

        System.out.println(cnt);
    }
}