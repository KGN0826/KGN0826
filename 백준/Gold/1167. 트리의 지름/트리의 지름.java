import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int to;
	int length;
	
	Node(int to, int length){
		this.to = to;
		this.length = length;
	}
}

public class Main {
	static int T;
	static ArrayList<Node>[] map;
	static boolean[] visited;
	static int[] distance;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		map = new ArrayList[T+1];
		for(int i=1;i<T+1;i++) {
			map[i] = new ArrayList<>();
		}//인접 리스트
		
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) break;
				
				int length = Integer.parseInt(st.nextToken());
				map[from].add(new Node(to,length));
			}
		}//인접 리스트에 입력값 저장
		
		//일단 제일 끝 노드 찾기
		visited = new boolean[T+1];
		distance = new int[T+1];
		int max1 = bfs(1);
		
		//끝 노드에서 제일 떨어진거
		visited = new boolean[T + 1];
        distance = new int[T + 1];
        int max2 = bfs(max1);
        
        int result = 0;
        for(int i=1;i<T+1;i++) {
        	result = Math.max(result, distance[i]);
        }
        System.out.println(result);
	}
	
	static int bfs(int a) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(a);
		visited[a] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (Node node : map[cur]) {
				if(!visited[node.to]) {
					visited[node.to] = true;
					distance[node.to] = distance[cur] + node.length;
					q.add(node.to);
				}
			}
		}
		
		int maaax = 0;
		int rNode = a;
		
		for(int i=1;i<T+1;i++) {
			if(distance[i] > maaax) {
				maaax = distance[i];
				rNode = i;
			}
		}
		return rNode;
	}
}
