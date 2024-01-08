import java.io.*;
import java.util.*;

class Main {
    static class Country{
        int name;
        int gold;
        int silver;
        int bronze;
        int num;
        Country(int name, int gold, int silver, int bronze, int num){
            this.name = name;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.num = num;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Country[] arr = new Country[N];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new Country(num, g, s, b, 0);
        }

        Arrays.sort(arr, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
               if (o1.gold != o2.gold){
                   return o2.gold - o1.gold;
               }
               if (o1.silver != o2.silver){
                   return o2.silver - o1.silver;
               }
               if (o1.bronze != o2.bronze){
                   return o2.bronze - o1.bronze;
               }
                return 0;
            }
        });
        int ans = 1;
        arr[0].num = 1;
        
        for (int i=1;i<N;i++){
            Country now = arr[i];
            Country temp = arr[i-1];

            if (temp.gold == now.gold && temp.silver == now.silver && temp.bronze == now.bronze){
                now.num = temp.num;
            }
            else{
                now.num = i+1;
            }
            if(now.name == K){
                ans = now.num;
                break;
            }
        }
        System.out.println(ans);
    }
}