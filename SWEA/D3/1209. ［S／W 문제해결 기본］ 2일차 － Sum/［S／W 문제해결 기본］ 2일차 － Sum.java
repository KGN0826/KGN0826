import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int[][] arr = new int[100][100];
			int t = Integer.parseInt(br.readLine());
			int maxRow = 0;
			int maxCol = 0;
			int maxDia1 = 0;
			int maxDia2 = 0;
			
			List<Integer> colList = new ArrayList<>();
			
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int sum = 0;
				for(int j=0;j<100;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum += arr[i][j];
					if(i==0) {
						colList.add(arr[i][j]);
					} else {
						colList.set(j,colList.get(j)+arr[i][j]);
					}
				}
				maxRow = Math.max(maxRow, sum);
			}
			maxCol = Collections.max(colList);
			
			for(int i=0, j=0;i<100;i++,j++) {
				maxDia1 +=arr[i][j];
				maxDia2 += arr[99-i][j];
			}
			int result = Math.max(Math.max(maxRow, maxCol), Math.max(maxDia1, maxDia2));
			
			StringBuilder sb = new StringBuilder();
			sb.append("#"+t+" "+result);
			System.out.println(sb);
		}
	}
}