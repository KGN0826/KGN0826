import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int t = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			int[] dr = {0,0,-1};
			int[] dc = {-1,1,0};
			int result = 0;
			
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<100;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j=0;j<100;j++) {
				if(arr[99][j] == 2) {
					int r = 99;
					int c = j;
					while(true) {
						if(c>0 && arr[r][c-1] == 1) {
							r = r+dr[0];
							c = c+dc[0];
							while(c>0 && arr[r][c-1] != 0) {
								r = r+dr[0];
								c = c+dc[0];
							}
							r = r+dr[2];
							c = c+dc[2];
						}else if(c<arr.length-1 && arr[r][c+1] == 1) {
							r = r+dr[1];
							c = c+dc[1];
							while(c<arr.length-1 &&arr[r][c+1] != 0) {
								r = r+dr[1];
								c = c+dc[1];
							}
							r = r+dr[2];
							c = c+dc[2];
						}
						if(c==0) {
							while(c<arr.length-1 && arr[r][c+1] != 1) {
								if(r == 0) {
									result = c;
									break;
								}
								r = r+dr[2];
								c = c+dc[2];
							}
						}else if(c==arr.length-1) {
							while(c>0 && arr[r][c-1] != 1) {
								if(r == 0) {
									result = c;
									break;
								}
								r = r+dr[2];
								c = c+dc[2];
							}
						}else {
							while(c>0 && c<arr.length-1 && arr[r][c-1] != 1 && arr[r][c+1] != 1) {
								if(r == 0) {
									result = c;
									break;
								}
								r = r+dr[2];
								c = c+dc[2];
							}
						}
						if(r == 0) {
							result = c;
							break;
						}
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+t+" "+result);
			System.out.println(sb);
		}
	}
}
