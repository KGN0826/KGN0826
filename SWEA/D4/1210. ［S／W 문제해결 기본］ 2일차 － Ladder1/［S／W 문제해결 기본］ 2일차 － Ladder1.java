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
			int result = 0;
			boolean flag = true;
			
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
					while(flag) {
						if(c>0 && arr[r][c-1] == 1) {
							c--;
							while(c>0 && arr[r][c-1] != 0) {
								c--;
							}
							r--;
						}else if(c<arr.length-1 && arr[r][c+1] == 1) {
							c++;
							while(c<arr.length-1 &&arr[r][c+1] != 0) {
								c++;
							}
							r--;
						}else {
							if(r == 0) {
								result = c;
								flag = false;
								break;
							}
							r--;
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
