import javax.print.attribute.IntegerSyntax;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (a+b > N+1){
            System.out.println(-1);
            System.exit(0);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max = Math.max(a,b);

        for (int i=1;i<a;i++){
            list.add(i);
        }
        list.add(max);

        for (int i=b-1;i>=1;i--){
            list.add(i);
        }
        if (a==1) {
            for (int i=list.size();i<N;i++){
                list.add(1,1);
            }
        }
        else{
            for (int i=list.size();i<N;i++){
                list.add(0,1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i:list){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}