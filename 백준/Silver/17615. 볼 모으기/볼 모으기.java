import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = new char[N];
        String s = br.readLine();
        arr = s.toCharArray();

        int min = Integer.MAX_VALUE;
        int red = 0;
        int blue = 0;

        for (int i=0;i<N;i++){
            if (arr[i] == 'R') red++;
            else blue++;
        }

        min = Math.min(red - leftCnt('R',arr), min);
        min = Math.min(red - rightCnt('R',arr), min);
        min = Math.min(blue - leftCnt('B',arr), min);
        min = Math.min(blue - rightCnt('B',arr), min);

        System.out.println(min);
    }

    public static int leftCnt(char color, char[] arr){
        int cnt = 0;

        for (int i=0;i<arr.length;i++){
            if (arr[i] == color){
                cnt++;
            }
            else break;
        }
        return cnt;
    }
    public static int rightCnt(char color, char[] arr){
        int cnt = 0;

        for (int i=arr.length-1;i>=0;i--){
            if (arr[i] == color){
                cnt++;
            }
            else break;
        }
        return cnt;
    }
}