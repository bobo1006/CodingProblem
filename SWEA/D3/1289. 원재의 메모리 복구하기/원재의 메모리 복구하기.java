import java.util.*;
import java.io.*;

class Solution
{	

	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String s = br.readLine();
			int[] arr = new int[s.length()];
			
			for(int i=0;i<s.length();i++) {
				arr[i] = s.charAt(i) - '0';
			}
			
			int cnt = 0;
			
			for(int i=0;i<arr.length;i++) {
	
				if((arr[i] == 0 && cnt % 2 == 1) 
						|| (arr[i] == 1 && cnt % 2 == 0)) {
					cnt++;
				}
			
			}
		
			sb.append("#" + test_case + " " + cnt).append('\n');
			
		}
		System.out.print(sb);
		
	}
	
}