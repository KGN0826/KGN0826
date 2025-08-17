import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		int n = Integer.parseInt(br.readLine());
		int pn = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int result = 0;
		int r2 = 0;
		int max = 0;
		int mc = 0;
		
		for(int i=1;i<=pn;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if(max < n2-n1) {
				max = n2 - n1;
				result = i;
			}
			
			int count = 0;
			for(int a=0;a<n2-n1+1;a++) {
				if(arr[n1-1+a] == 0) {
					arr[n1-1+a] = i;
					count++;
				}
			}
			if(mc < count) {
				mc = count;
				r2 = i;
			}
		}
		System.out.println(result);
		System.out.println(r2);
	}
}
