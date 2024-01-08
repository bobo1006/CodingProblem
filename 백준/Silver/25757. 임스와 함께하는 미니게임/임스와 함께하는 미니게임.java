import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int people = 0;

        if (game.equals("Y")){
            people = 1;
        }
        else if (game.equals("F")){
            people = 2;
        }
        else{
            people = 3;
        }

        HashSet<String> hashSet = new HashSet<>();
        for (int i=0;i<N;i++){
            hashSet.add(br.readLine());
        }

        System.out.println(hashSet.size()/people);
    }
}