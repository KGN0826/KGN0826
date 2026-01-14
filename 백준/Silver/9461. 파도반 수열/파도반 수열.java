import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<t;tc++) {
			long[] arr = new long[101];
			
			arr[0] = 1;
			arr[1] = 1;
			arr[2] = 1;
			
			int N = Integer.parseInt(br.readLine());
			
			for(int i=3;i<N;i++) {
				arr[i] = arr[i-2] + arr[i-3];
			}
			
			if(N == 0) {
				System.out.println(0);
				return;
			}
			System.out.println(arr[N-1]);
		}
	}
}
