import java.io.*;
        import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq_n = new PriorityQueue<>();
        PriorityQueue<Integer> pq_p = new PriorityQueue<>(Collections.reverseOrder());
        boolean zero = false;

        for (int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());

            if (num < 0){
               pq_n.add(num);
            }
            else if (num > 0){
                pq_p.add(num);
            }
            else zero = true;
        }

        int sum = 0;

        while (!pq_n.isEmpty()){
            if (pq_n.size() == 1){
                if (zero) break;
                sum += pq_n.poll();
                break;
            }
            int n1 = pq_n.poll();
            int n2 = pq_n.poll();

            sum += n1 * n2;
        }

        while (!pq_p.isEmpty()){
            if (pq_p.size() == 1){
                sum += pq_p.poll();
                break;
            }
            int n1 = pq_p.poll();
            int n2 = pq_p.poll();
            if (n2 == 1){
                sum += n1 + n2;
                continue;
            }
            sum += n1 * n2;
        }
        System.out.println(sum);
    }
}