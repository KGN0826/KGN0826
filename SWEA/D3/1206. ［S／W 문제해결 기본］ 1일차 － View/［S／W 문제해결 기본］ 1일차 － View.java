import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			int count = Integer.parseInt(br.readLine());
			int[] arr = new int[count];
			int result = 0;
			
			String[] input = br.readLine().trim().split(" ");
			for(int i=0;i<count;i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			for(int i=2;i<arr.length-2;i++) {
				int max1 = Math.max(arr[i-1], arr[i-2]);
				int max2 = Math.max(arr[i+1], arr[i+2]);
				int r_max = Math.max(max1, max2);
				if(arr[i] > r_max) {
					result += (arr[i]-r_max);
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+t+" "+result);
			System.out.println(sb);
		}
	}
}