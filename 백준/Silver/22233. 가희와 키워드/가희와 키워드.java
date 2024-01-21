import java.io.*;
        import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();
        for (int i=0;i<N;i++){
            String s = br.readLine();
            hashSet.add(s);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<M;i++){
            String[] temp = br.readLine().split(",");

            for (int j=0;j< temp.length;j++){
                hashSet.remove(temp[j]);
            }
            sb.append(hashSet.size()).append('\n');
        }

        System.out.println(sb);
    }
}