import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y){
                ans++;
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == y) continue;
            stack.push(y);
        }
        while (!stack.isEmpty() && stack.pop() > 0){
            ans++;
        }
        System.out.println(ans);
    }
}