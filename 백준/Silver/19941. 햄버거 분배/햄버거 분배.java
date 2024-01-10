import java.io.*;
        import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = new char[N];
        boolean[] visited = new boolean[N];
        int num = 0;

        arr = br.readLine().toCharArray();

        for (int i=0;i<N;i++){
            char c = arr[i];

            if (c ==  'P'){
                int start = Math.max(i-K, 0);
                int end = Math.min(i+K, N-1);
                for (int j=start;j<=end;j++){
                    if (arr[j] == 'H' && !visited[j]){
                        num++;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(num);

    }
}