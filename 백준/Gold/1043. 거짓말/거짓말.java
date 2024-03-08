import java.io.*;
import java.util.*;

class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for (int i=1;i<=N;i++){
            arr[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for (int i=0;i<K;i++){
            arr[Integer.parseInt(st.nextToken())] = 0;
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i=0;i<M;i++){
            list.add(new ArrayList());
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            list.get(i).add(n1);

            for (int j=0;j<num-1;j++){
                int n2 = Integer.parseInt(st.nextToken());
                list.get(i).add(n2);
                union(n1,n2);
            }
        }
        int cnt = M;

        for (int i=0;i<M;i++){
            for (int p:list.get(i)){
                if (find(p) == 0) {
                    cnt--;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a > b){
            arr[a] = b;
        }
        else{
            arr[b] = a;
        }
    }

    public static int find(int a){
        if (arr[a] == a){
            return a;
        }

        return arr[a] = find(arr[a]);
    }
}