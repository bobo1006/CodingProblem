import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int[] indegree;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		indegree = new int[N+1];
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list.get(s).add(e);
			indegree[e]++;
		}
		topoSort();
		System.out.println(sb);
	}
	
	public static void topoSort() {
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			if(indegree[i] == 0) {
				que.add(i);				
			}
		}
		
		while(!que.isEmpty()) {
			int temp = que.poll();
			sb.append(temp+" ");
			
			for(int i:list.get(temp)) {
				indegree[i]--;
				if(indegree[i] == 0) {
					que.add(i);
				}
			}
		}
			
	}
}                                                                                                                                            