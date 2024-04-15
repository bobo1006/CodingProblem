import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());

            for (int j=0;j<N;j++){
                arr[j] = Integer.parseInt(st.nextToken());
                hashMap.put(arr[j], hashMap.getOrDefault(arr[j], 0) + 1);
            }

            int score = 1;
            int[] rank = new int[hashMap.size()+1];
            int[] cnt = new int[hashMap.size()+1];
            int[] fifth = new int[hashMap.size()+1];

            for (int j=0;j<N;j++){
                if (hashMap.get(arr[j]) == 6){
                    if (cnt[arr[j]] < 4){
                        rank[arr[j]] += score;
                        cnt[arr[j]]++;
                    }
                    else if (cnt[arr[j]] == 4) {
                        fifth[arr[j]] = score;
                        cnt[arr[j]]++;
                    }
                    score++;
                }
            }

            int answer = 1;
            for (int j=1;j<= hashMap.size();j++){
                if (rank[j] == 0){
                    rank[j] = Integer.MAX_VALUE;
                }
            }

            for (int j=2;j<= hashMap.size();j++){

                if (rank[j] < rank[answer]){
                    answer = j;
                }
                else if (rank[j] == rank[answer]){
                    if (fifth[j] < fifth[answer]) answer = j;
                }
            }
            System.out.println(answer);
        }
    }

}