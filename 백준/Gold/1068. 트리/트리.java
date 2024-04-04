import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        int root = 0;

        for (int i=0;i<N;i++){
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if (num == -1){
                root = i;
                continue;
            }
            list[num].add(i);
        }
        int del = Integer.parseInt(br.readLine());
        if (del == root) System.out.println(0);
        else System.out.println(cntLeafNode(N,root,del));

    }

    private static int cntLeafNode(int N, int root, int del){
       Queue<Integer> queue = new LinkedList<>();
       queue.add(root);
       int cnt = 0;

       while (!queue.isEmpty()){
           int now = queue.poll();
           boolean child = false;

           for (int node:list[now]){
               if (node != del){
                   queue.add(node);
                   child = true;
               }
           }
           if (!child) cnt++;
       }
       return cnt;
    }
}