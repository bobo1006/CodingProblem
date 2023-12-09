import java.io.*;
import java.util.*;

class Main {
    static class Node{
        int index;
        int value;
        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            int value = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty()){
                Node temp = deque.getLast();
                if (temp.value > value){
                    deque.removeLast();
                }
                else break;
            }
            deque.addLast(new Node(i,value));

            if (deque.getFirst().index < i-L+1){
                deque.removeFirst();
            }
            sb.append(deque.getFirst().value).append(" ");
        }
        System.out.println(sb);
    }
}