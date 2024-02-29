import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] counting = new int[N+1];
        int[] min = new int[N+1];
        Arrays.fill(min, N * -1);
        cntBuildings(N, arr, counting, min);

        for (int i=1;i<=N;i++){
            if (counting[i] == 0){
                sb.append(counting[i]).append('\n');
            }
            else{
                sb.append(counting[i]).append(" ").append(min[i]).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static void cntBuildings(int N, int[] arr, int[] counting, int[] min) {
        Stack<Integer> stack = new Stack<>();

        for (int i=1;i<=N;i++){
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            counting[i] = stack.size();
            if (counting[i] > 0){
                min[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();

        for (int i=N;i>0;i--){
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            counting[i] += stack.size();
            if (!stack.isEmpty() && stack.peek() - i < i - min[i]){
                min[i] = stack.peek();
            }
            stack.push(i);
        }
    }
}