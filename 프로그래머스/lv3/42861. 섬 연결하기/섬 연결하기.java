import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] arr;
    public int solution(int n, int[][] costs) {

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = i;
        }

        int answer = link(costs);
        return answer;
    }
    private int link(int[][] costs){
        int ans = 0;

        for (int i=0;i< costs.length;i++){
            int node1 = costs[i][0];
            int node2 = costs[i][1];
            int val = costs[i][2];

            if (find(node1) != find(node2)){
                union(node1, node2);
                ans += val;
            }
        }
        return ans;
    }

    private void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a >= b){
            arr[a] = b;
        }
        else if (b > a){
            arr[b] = a;
        }
    }
    private int find(int a){
        if (a == arr[a]){
            return a;
        }
        return arr[a] = find(arr[a]);
    }
}