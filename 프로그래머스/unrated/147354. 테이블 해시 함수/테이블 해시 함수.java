import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        sort(data, col);
        int[] arr_S = new int[data.length];
        save_S(data, row_begin, row_end, arr_S);
        int answer = xor_Bitwise(arr_S, row_begin, row_end);

        return answer;
    }

    private void sort(int[][] data, int col) {
        Arrays.sort(data, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if (o1[col-1] == o2[col-1]){
                    return o2[0] - o1[0];
                }
                return o1[col-1] - o2[col-1];
            }
        });
    }

    private void save_S(int[][] data, int row_begin, int row_end, int[] arr_S) {
        for (int i=row_begin-1; i<row_end; i++){
            int s = 0;
            for (int j: data[i]){
                s += j % (i+1);
            }
            arr_S[i] = s;
        }
    }

    private int xor_Bitwise(int[] arr, int begin, int end){
        int temp = arr[begin-1];

        for (int i=begin;i<end;i++){
            temp = temp ^ arr[i];
        }

        return temp;
    }
}