import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException{
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));						
		String[] arr1 = br.readLine().split("-");
		boolean sw = true;
		int ans = 0;
		for(int i=0;i<arr1.length;i++) {
			
			String[] arr2 = arr1[i].split("\\+");
			int H = 0;
			for(int j=0;j<arr2.length;j++) {
				H += Integer.parseInt(arr2[j]);
			}
			
			if(sw) {
				ans = H;
				sw = false;
			}
			else {
				ans -= H;
			}
			
		}
		
		System.out.println(ans);										
	
	}
		
}
