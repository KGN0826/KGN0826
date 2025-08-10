import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			int n = Integer.parseInt(br.readLine());
			List<Integer> list = new ArrayList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<100;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			while(n != 0) {
				int maxValue = Collections.max(list);
				int minValue = Collections.min(list);
				
				if(maxValue - minValue <=1) {
					break;
				}
				int maxIndex = list.indexOf(maxValue);
				int minIndex = list.indexOf(minValue);
				
				list.set(maxIndex, maxValue - 1);
				list.set(minIndex, minValue + 1);
				n--;
			}
			
			int result = Collections.max(list) - Collections.min(list);
			StringBuilder sb = new StringBuilder();
			sb.append("#"+t+" ").append(result);
			System.out.println(sb);
		}
	}
}
