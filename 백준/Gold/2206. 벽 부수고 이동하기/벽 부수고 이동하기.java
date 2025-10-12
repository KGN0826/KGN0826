import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int result;
	
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 
		 map = new int[N][M];
		 visited = new boolean[N][M][2];
		 result = -1;
		 
		 for(int i=0;i<N;i++) {
			 String a = br.readLine();
			 for(int j=0;j<M;j++) {
				 map[i][j] = a.charAt(j) - '0';
			 }
		 }
		 
		 bfs(0,0,0,0);
		 
		 System.out.println(result);
	}
	
	static void bfs(int r, int c, int count, int wall) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r,c,1,wall});
		visited[r][c][wall] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == N-1 && cur[1] == M-1) {
				result = cur[2];
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nr = cur[0] +dr[i];
				int nc = cur[1] +dc[i];
				
				if(nr<0||nc<0||nr>=N||nc>=M) continue;
				if(visited[nr][nc][cur[3]]) continue;
				if(cur[3] == 1 && map[nr][nc] == 1) continue;

				if(cur[3] == 0) {
					if(map[nr][nc] == 1) {
						visited[nr][nc][1] = true;
						q.add(new int[] {nr,nc,cur[2]+1, 1});
					}
					else {
						visited[nr][nc][cur[3]] = true;						
						q.add(new int[] {nr,nc,cur[2]+1,cur[3]});
					}
				}else {
					visited[nr][nc][1] = true;
					q.add(new int[] {nr,nc,cur[2]+1,cur[3]});
				}
			}
		}
	}
}
