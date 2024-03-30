import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] degree = new int[n+1];
        int[] value = new int[n+1];
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        ArrayList<ArrayList<int[]>> reverseList = new ArrayList<>();

        for (int i=0;i<=n;i++){
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }
        for (int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.get(n1).add(new int[]{n2,t});
            reverseList.get(n2).add(new int[]{n1,t});
            degree[n2]++;
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        topologicalSort(list, degree, value, start);
        System.out.println(value[end]);
        System.out.println(cntRoad(reverseList, value, end));
    }
    private static void topologicalSort(ArrayList<ArrayList<int[]>> list, int[] degree, int[] value, int num){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while (!queue.isEmpty()){
            int now = queue.poll();

            for (int[] next:list.get(now)){
                degree[next[0]]--;
                value[next[0]] = Math.max(value[next[0]], value[now] + next[1]);
                if (degree[next[0]] == 0) queue.add(next[0]);
            }
        }
    }

    private static int cntRoad(ArrayList<ArrayList<int[]>> list, int[] value, int num){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[value.length];
        queue.add(num);
        int cnt = 0;
        visited[num] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();

            for (int[] next:list.get(now)){
                if (value[now] - next[1] == value[next[0]]){
                    cnt++;
                    if (!visited[next[0]]){
                        visited[next[0]] = true;
                        queue.add(next[0]);
                    }
                }
            }
        }
        return cnt;
    }

}