import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int max = 0;

        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<W;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[max] < arr[i]){
                max = i;
            }
        }

        int[] cnt = new int[W];
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0;i<max;i++){
            if (stack.isEmpty()){
                stack.push(arr[i]);
                continue;
            }
            if (stack.peek() > arr[i]){
                cnt[i] = stack.peek() - arr[i];
            }
            else if (stack.peek() <= arr[i]){
                stack.pop();
                stack.push(arr[i]);
            }
        }
        stack.clear();
        
        for (int i=W-1;i>max;i--){
            if (stack.isEmpty()){
                stack.push(arr[i]);
                continue;
            }
            if (stack.peek() > arr[i]){
                cnt[i] = stack.peek() - arr[i];
            }
            else if (stack.peek() <= arr[i]){
                stack.pop();
                stack.push(arr[i]);
            }
        }

        System.out.println(Arrays.stream(cnt).sum());
    }
}