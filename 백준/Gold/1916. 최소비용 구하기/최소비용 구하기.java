import java.io.*;
import java.util.*;

class City implements Comparable<City> {
	int num;
	int value;
	
	City(int num, int value){
		this.num = num;
		this.value = value;
	}
	
	@Override
	public int compareTo(City c) {
		return value - c.value;
	}
}
public class Main {
	
	static int[] arr;
	static boolean[] visited;
	static ArrayList<ArrayList<City>> list = new ArrayList<>();
	static StringTokenizer st;
	
	public static void main(String args[]) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		visited = new boolean[N+1];
		
		Arrays.fill(arr, Integer.MAX_VALUE);
		
		for(int i=0;i<N+1;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int j=0;j<M;j++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new City(end,dist));
		}
		st  = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijk(start,end));
					
	}
	public static int dijk(int start, int end) {
		PriorityQueue<City> que = new PriorityQueue<>();
		que.add(new City(start,0));
		arr[start] = 0;
		
		while(!que.isEmpty()) {
			City nextCity = que.poll();
			int numCity = nextCity.num;
			
			if(!visited[numCity]) {
				visited[numCity] = true;
				
				for(City i:list.get(numCity)) {
					if(!visited[i.num]) {
						arr[i.num] = Math.min(arr[i.num], arr[numCity] + i.value);
						que.add(new City(i.num, arr[i.num]));
					}
				}
				
			}
		}
		return arr[end];
	}

}
