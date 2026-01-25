import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int result_x, result_y, cn;
	static boolean result;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<t;tc++) {
			result = false;
			cn = Integer.parseInt(br.readLine());
			
			visited = new boolean[cn+2];
			map = new int[cn+2][2];
			
			for(int i=0;i<cn+2;i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken());
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			
			result_x = map[cn+1][0];
			result_y = map[cn+1][1];
			
			visited[0] = true;
			find(map[0][0], map[0][1]);
			
			if(result) System.out.println("happy");
			else System.out.println("sad");
		}
	}
	
	static void find(int x, int y) {
		if(x == result_x && y == result_y) {
			result = true;
			return;
		}
		
		for (int i=1 ;i<cn+2;i++) {
			if(visited[i] == true) continue;
			
			int[] is = map[i];
			
			int length  = Math.abs(x-is[0]) + Math.abs(y-is[1]);
			
			if(length <= 1000) {
				visited[i] = true;
				find(is[0], is[1]);
			}
			if(result) return;
		}
	}
}
