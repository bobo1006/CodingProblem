import java.io.*;
import java.util.*;

class Main {
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static int[] arr;
    static int start;
    static int end;
    static int N;
    static int c;
    static int max = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        start = 0;
        end = k;

        for (int i=start;i<end;i++){
            if (hashMap.containsKey(arr[i])){
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            }
            else{
                hashMap.put(arr[i], 1);
            }
        }
        getMax();

        while (start < N){
            remove();
            add();
            getMax();
        }
        System.out.println(max);
    }

    public static void remove(){
        int val = hashMap.get(arr[start]);

        if (val > 1){
            hashMap.put(arr[start], val - 1);
        }
        else if (val == 1){
            hashMap.remove(arr[start]);
        }
        start++;
    }
    public static void add(){
        if (hashMap.containsKey(arr[end])){
            hashMap.put(arr[end], hashMap.get(arr[end]) + 1);
        }
        else{
            hashMap.put(arr[end], 1);
        }
        end++;
        if (end == N) end = 0;
    }
    public static void getMax(){
        if (hashMap.containsKey(c)){
            max = Math.max(hashMap.size(), max);
        }
        else{
            max = Math.max(hashMap.size() + 1, max);
        }
    }
}