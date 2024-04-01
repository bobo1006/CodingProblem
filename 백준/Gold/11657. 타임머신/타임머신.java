import java.util.*;
import java.io.*;

class Bus{
	int end, cost;
	
	Bus(int end,int cost){
		this.end = end;
		this.cost = cost;
	}
}

public class Main {
	
	static ArrayList<ArrayList<Bus>> list = new ArrayList<>();
	static final long INF = 10000000000L;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] dist = new long[N+1];
		
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
			dist[i] = INF;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			list.get(A).add(new Bus(B,C));
		}
		
		dist[1] = 0;
		
		bell(N,dist);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=2;i<=N;i++) {
			if(dist[i] == INF) {
				sb.append(-1).append('\n');
			}
			else {
				sb.append(dist[i]).append('\n');
			}
		}
		System.out.println(sb);
	}

	public static void bell(int N, long[] dist) {
		boolean cycle = false;
		
		for(int i=1;i<N;i++) {
			cycle = false;
			
			for(int j=1;j<=N;j++) {
				
				for(Bus bus:list.get(j)) {
					if(dist[j] == INF) break;
					
					if(dist[bus.end] > dist[j] + bus.cost) {
						dist[bus.end] = dist[j] + bus.cost;
							cycle = true;
						}
					}
					
				}
			}
		
		if(cycle) {
			for(int j=1;j<=N;j++) {
				for(Bus bus:list.get(j)) {
					if(dist[j] == INF) break;
					
					if(dist[bus.end] > dist[j] + bus.cost) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		
	}
}                                                                                                                                            