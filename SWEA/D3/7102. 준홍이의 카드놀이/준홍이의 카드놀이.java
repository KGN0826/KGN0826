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
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			int[] arr2 = new int[m];
			
			for(int i=0;i<n;i++) {
				arr[i] = i+1;
			}
			for(int i=0;i<m;i++) {
				arr2[i] = i+1;
			}
			
			List<Integer> sum = new ArrayList<>();
			
			for(int i=0;i<n+m+1;i++) {
				sum.add(0);
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					sum.set(arr[i]+arr2[j], sum.get(arr[i]+arr2[j])+1);
				}
			}
			
			int max = Collections.max(sum);
			List<Integer> result = new ArrayList<>();
			
			for(int i=0;i<sum.size();i++) {
				if(sum.get(i) == max) {
					result.add(i);
				}
			}
			Collections.sort(result);
			
			System.out.print("#"+tc+" ");
			for(int i=0;i<result.size();i++) {
				System.out.print(result.get(i) + " ");
			}
			System.out.println();
		}
	}
}
