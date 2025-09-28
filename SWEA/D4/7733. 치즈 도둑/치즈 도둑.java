import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N,max;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			max = Integer.MIN_VALUE;
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = max<map[i][j] ? map[i][j] : max;
				}
			}
			
			int result = 1;
			for(int i=1;i<=max;i++) {
				int count = 0;
				visited = new boolean[N][N];
				for(int r=0;r<N;r++) {
					for(int c=0;c<N;c++) {
						if(visited[r][c] || map[r][c] <= i) continue;
						bfs(r,c,i);
						count++;
					}
				}
				if(result < count) result = count;
			}
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static void bfs(int r, int c, int day) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for(int i=0;i<4;i++) {
				int nr = cur[0]+dr[i];
				int nc = cur[1]+dc[i];
				
				if(nr<0||nc<0||nr>=N||nc>=N) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] <= day) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr,nc});
			}
		}
	}
}
