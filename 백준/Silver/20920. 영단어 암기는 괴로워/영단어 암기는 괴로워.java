import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> hashMap = new HashMap<>();

        for (int i=0;i<N;i++){
            String s = br.readLine();
            int len = s.length();

            if (len >= M){
                if (hashMap.containsKey(s)){
                    hashMap.put(s, hashMap.get(s)+1);
                }
                else{
                    hashMap.put(s, 1);
                }
            }
        }

        ArrayList<String> list = new ArrayList<>(hashMap.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (hashMap.get(o1) > hashMap.get(o2)){
                    return -1;
                }
                if (hashMap.get(o1) == hashMap.get(o2)){
                    if (o1.length() == o2.length()){
                        return o1.compareTo(o2);
                    }
                    return o2.length() - o1.length();
                }
                return 1;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (String s:list){
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }
}