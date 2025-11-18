import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,0,1,0}; //북서남동
	static int[] dc = {0,-1,0,1};
	static int[][] map;
	static boolean[][] visited;
	static int N,M;
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		if(dir == 1) {
			dir = 3;
		}else if(dir ==3) {
			dir = 1;
		}
		
		map = new int[N][M];
		visited = new boolean[N][M];
		count = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(r,c,dir);
		System.out.println(count);
	}
	
	static void clean(int r, int c, int dir) {
		visited[r][c] = true;
		count++;
		
		while(true) {
			if(check(r,c)) {
				for(int i=0;i<4;i++) {
					dir = (dir+1)%4;
					int nr = r+dr[dir];
					int nc = c+dc[dir];
					
					if(nr<0||nc<0||nr>=N||nc>=M) continue;
					if(map[nr][nc] == 1 || visited[nr][nc]) continue;
					
					visited[nr][nc] = true;
					count++;
					r = nr;
					c = nc;
					break;
				}
			}else {
				int nd = (dir+2)%4;
				int nr = r+dr[nd];
				int nc = c+dc[nd];
				
				if(map[nr][nc] == 1) return;
				
				r = nr;
				c = nc;
			}
		}
	}
	
	static boolean check(int r, int c) {
		for(int i=0;i<4;i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr<0||nc<0||nr>=N||nc>=M) continue;
			if(map[nr][nc] == 1 || visited[nr][nc]) continue;
			
			return true;
		}
		return false;
	}
}
