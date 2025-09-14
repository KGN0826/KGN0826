import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int startx, starty;
	static int endx, endy;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		startx = Integer.parseInt(st.nextToken()) -1;
		starty = Integer.parseInt(st.nextToken()) -1;
		
		st = new StringTokenizer(br.readLine());
		endx = Integer.parseInt(st.nextToken()) -1;
		endy = Integer.parseInt(st.nextToken()) -1;
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = Integer.MAX_VALUE;
		int a = bfs(startx,starty,0,0);
		
		if(a == Integer.MAX_VALUE) 
			System.out.println(-1);
		else
			System.out.println(a);
		
	}
	
	static int bfs(int r, int c, int w, int count) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c, w, count});
		visited[r][c][w] = true;
		
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int row = cur[0];
			int col = cur[1];
			int wall = cur[2];
			int dist = cur[3];
			
			if(row == endx && col == endy) {
				result = Math.min(result, dist);
				return result;
			}
			
			
			for(int i=0;i<4;i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(visited[nr][nc][wall]) continue;
				
				if(map[nr][nc] == 0) {
					visited[nr][nc][wall] = true;
					q.add(new int[] {nr,nc,wall,dist+1});
				}
				if(map[nr][nc] == 1 && wall == 0) {
					visited[nr][nc][1] = true;
					q.add(new int[] {nr,nc,1,dist+1});
				}
			}
		}
		return -1;
	}
}
