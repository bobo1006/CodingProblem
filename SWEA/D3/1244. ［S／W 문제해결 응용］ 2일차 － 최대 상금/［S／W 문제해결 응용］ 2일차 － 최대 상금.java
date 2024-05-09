import java.util.*;
import java.io.*;

class Solution
{	
	static int max;
	
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String num = st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			
			if(cnt > num.length()) cnt = num.length();
			
			max = 0;
			dfs(cnt, num.toCharArray());
			sb.append("#" + test_case + " " + max).append('\n');
		}
		System.out.print(sb);
		
	}
	
	private static void dfs(int d, char[] number) {
		if(d == 0) {
			max = Math.max(max, Integer.parseInt(String.valueOf(number)));
			return;
		}
		
		for(int i=0;i<number.length-1;i++) {
			for(int j=i+1;j<number.length;j++) {
				swap(i,j,number);
				dfs(d-1, number);
				swap(i,j,number);
			}
		}
	}
	
	private static void swap(int i, int j, char[] number) {
		char temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	
	}
}