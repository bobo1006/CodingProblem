
import java.io.*;
import java.util.*;

class Node{
	int node;
	int value;
	Node(int node, int value){
		this.node = node;
		this.value = value;
	}
}
class Len{
	int node;
	int length;
	Len(int node, int length){
		this.node = node;
		this.length = length;
	}
}

public class Main {
	
	static boolean[] visited;
	static Len max = new Len(0,0);
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int V = Integer.parseInt(br.readLine());
        visited = new boolean[V+1];
        
        for(int i=0;i<V+1;i++) {
        	list.add(new ArrayList<>());
        }
       
        for(int i=0;i<V;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int number = Integer.parseInt(st.nextToken());
        	while(true) {
        		int a = Integer.parseInt(st.nextToken());
        		if(a == -1) break;
        		int b = Integer.parseInt(st.nextToken());
        		
        		list.get(number).add(new Node(a,b));
        	}
        }
        bfs(1);
        visited = new boolean[V+1];
        bfs(max.node);
        System.out.println(max.length);
        
	}
	public static void bfs(int number) {
		Queue<Len> que = new LinkedList<>();
		que.add(new Len(number,0));

		visited[number] = true;
		
		while(!que.isEmpty()) {
			Len now = que.poll();
			int nowNode = now.node;
			int nowLen = now.length;
			
			if(nowLen > max.length) {
				max.length = nowLen;
				max.node = nowNode;
			}
			for(Node n : list.get(nowNode)) {
				if(!visited[n.node]) {
					visited[n.node] = true;
					que.add(new Len(n.node, nowLen + n.value));
				}
												
			}
		}
	}
	
}