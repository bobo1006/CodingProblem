
import java.io.*;
import java.util.*;
 
public class Main {
	
    static int[] visited;
    static ArrayList<ArrayList<Integer>> list;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
               
        for(int i=0;i<K;i++) {
        	list = new ArrayList<>();
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int V = Integer.parseInt(st.nextToken());
        	int E = Integer.parseInt(st.nextToken());
        	visited = new int[V+1];
        	
        	for(int v=0;v<=V;v++) {
        		list.add(new ArrayList<>());
        	}
        	      	
        	for(int j=0;j<E;j++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		
        		list.get(a).add(b);
        		list.get(b).add(a);
        	}
        	if(bfs(V)) {
        		sb.append("YES").append('\n');
        	}
        	else {
        		sb.append("NO").append('\n');
        	}
        	
        }

        System.out.println(sb); 
    }
 
    public static boolean bfs(int v) {
    	Queue<Integer> que = new LinkedList<Integer>();
    	
    	for(int i=1;i<=v;i++) {
    		if(visited[i]==0) {
    			que.add(i);
    			visited[i] = 1;
    		}
    		while(!que.isEmpty()) {
        		int n = que.poll();
        		
        		for(int j=0;j<list.get(n).size();j++) {
        			if(visited[list.get(n).get(j)] == 0) {
        				que.add(list.get(n).get(j));
        			}
        			if(visited[list.get(n).get(j)] == visited[n]) {
        				return false;
        			}
        			
        			if(visited[list.get(n).get(j)] == 0 && visited[n] == 1) {
        				visited[list.get(n).get(j)] = 2;
        			}
        			else if(visited[list.get(n).get(j)] == 0 && visited[n] == 2) {
        				visited[list.get(n).get(j)] = 1;
        			}
        		}
        	}
    		
    	}
    	return true;
    	
    }

}
