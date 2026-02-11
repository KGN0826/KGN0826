/*
 * 말은 체스의 나이트와 같다.
 * 원숭이는 K번만 말과 같이 움직이고 인접한 칸으로만 움직인다.
 * (대각선은 인접한게 아니다.)
 * 맨 왼쪽 위에서 맨 오른쪽 아래까지 가야한다.
 * 원숭이가 최소한의 동작으로 가는 방법
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int K,W,H;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] dd = {{1,-2}, {2,-1}, {2,1}, {1,2}, {-1,2}, {-2,1}, {-2,-1},{-1,-2}};
	static boolean[][][] visited;
	static int result, flag;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 말처럼 이동할 수 있는 횟수 K
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		//W: 가로 H: 세로
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		result = Integer.MAX_VALUE;
		flag = 0;
		
		// map 채우기
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0,0,0,0);
		
		if(flag == 1) 
			System.out.println(result);
		else
			System.out.println(-1);
	}
	
	static void bfs(int x, int y, int kCount, int length) {
		Queue<int[]> q = new ArrayDeque();
		visited[x][y][0]= true;
		q.add(new int[] {x,y,0,0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			if(cur[0] == H-1 && cur[1] == W-1) {
				flag = 1;
				result = Math.min(result, cur[3]);
				continue;
			}
			
			if(cur[2] < K) {
				for(int i=0;i<8;i++) {
					int nr = cur[0] + dd[i][0];
					int nc = cur[1] + dd[i][1];
					
					if(nr<0||nc<0||nr>=H||nc>=W) continue;
					if(map[nr][nc] == 1) continue;
					if(visited[nr][nc][cur[2]+1]) continue;
					
					visited[nr][nc][cur[2]+1] = true;
					q.add(new int[] {nr,nc,cur[2]+1, cur[3]+1});
				}
			}
			
			for(int i=0;i<4;i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				
				if(nr<0||nc<0||nr>=H||nc>=W) continue;
				if(map[nr][nc] == 1) continue;
				if(visited[nr][nc][cur[2]]) continue;
				
				visited[nr][nc][cur[2]] = true;
				q.add(new int[] {nr,nc,cur[2], cur[3]+1});
			}
		}
	}
}
