import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int v;
	int w;
	
	public Node(int v, int w) {
		this.v = v;
		this.w = w;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.w-o.w;
	}
}


public class Main {
	static int[] dist;
	static List<Node>[] graph;
	static final int max = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		for(int i=1; i<=V;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, w));
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, max);
		
		di(start);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<V+1;i++) {
			if(dist[i] == max) {
				sb.append("INF\n");
			}else {
				sb.append(dist[i]).append("\n");
			}
		}
		System.out.println(sb);
		
	}
	
	
	static void di(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int cur = now.v;
			int curD = now.w;
			
			if(dist[cur] < curD) {
				continue;
			}
			
			for(Node next : graph[cur]) {
				int cost = dist[cur] + next.w;
				if(cost < dist[next.v]) {
					dist[next.v] = cost;
					pq.add(new Node(next.v, cost));
				}
			}
		}
	}
}
