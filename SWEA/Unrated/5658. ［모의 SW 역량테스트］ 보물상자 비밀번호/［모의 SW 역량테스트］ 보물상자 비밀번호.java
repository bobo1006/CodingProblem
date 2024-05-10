import java.util.*;
import java.io.*;

class Solution
{	
	static HashSet<Integer> hashset;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int len = N/4;
			char[] arr = br.readLine().toCharArray();
			hashset = new HashSet<>();
			
			parseAndAddSet(arr, len);
			
			for(int i=0;i<len-1;i++) {
				rotate(arr);
				parseAndAddSet(arr,len);
			}
			ArrayList<Integer> list = new ArrayList<>(hashset);
			Collections.sort(list, Collections.reverseOrder());;
			sb.append("#" + test_case + " " + list.get(K-1)).append('\n');
			
		}
		System.out.print(sb);
		
	}
	
	private static void rotate(char[] arr) {
		char temp = arr[arr.length-1];
		
		for(int i=arr.length-1;i>=1;i--) {
			arr[i] = arr[i-1];
		}
		
		arr[0] = temp;
	}
	private static void parseAndAddSet(char[] arr, int len) {
		int idx = 0;
	
		for(int i=0;i<4;i++) {
			String s = "";
			
			for(int j=idx;j<idx+len;j++) {
				s += arr[j];
			}
			idx += len;
			hashset.add(Integer.parseInt(s, 16));
		}
		
	}
}