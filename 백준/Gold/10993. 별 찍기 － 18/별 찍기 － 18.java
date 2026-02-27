import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int r = (1 << N) - 1; //세로
		int c = (1 << (N+1)) - 3; //가로
		
		map = new char[r][c];
		for(int i=0;i<r;i++) {
			Arrays.fill(map[i], ' ');
		}
		
		
		draw(N, 0, c/2, N%2);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<r;i++) {
			// 오른쪽 공백 제거
			int last = c - 1;
		    while (last >= 0 && map[i][last] == ' ') last--;  
		    
			for(int j=0;j<= last;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void draw(int n, int top, int center, int dir) {
		int h = (1 << n) - 1; // 높이

		if(n == 1) {
			map[top][center] = '*';
			return;
		}
		//홀수일 때,
		if (dir == 1) {
		    for (int i = 0; i < h; i++) {
		        int r = top + i;

		        // 왼/오 대각선
		        map[r][center - i] = '*';
		        map[r][center + i] = '*';

		        // 밑변 (마지막 줄)
		        if (i == h - 1) {
		            for (int c = center - (h - 1); c <= center + (h - 1); c++) {
		                map[r][c] = '*';
		            }
		        }
		    }
		    int nextT = top+ h/2;
		    draw(n-1, nextT, center, 0);
		}
		//짝수일 때
		else {
			for (int i = 0; i < h; i++) {
		        int r = top + i;
		        
		        // 밑변 (마지막 줄)
		        if (i == 0) {
		        	for (int c = center - (h - 1); c <= center + (h - 1); c++) {
		        		map[r][c] = '*';
		        	}
		        }

		        // 왼/오 대각선
		        map[r][center - (h-1-i)] = '*';
		        map[r][center + (h-1-i)] = '*';

		    }
			int nextT = top +1;
		    draw(n-1, nextT, center, 1);
		}
	}
}
