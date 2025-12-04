import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; // 초기 배열
		int[] dp = new int[N]; //최댓값 저장 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(N == 1) {
			System.out.println(arr[0]);
			return;
		}
		
		// i번째 숫자를 마지막으로 하는 증가 부분 수열의 최대 합
		dp[0] = arr[0]; //첫 번째 최대 합은 당연히 자기 자신 
		int result = dp[0];
		for(int i=1;i<N;i++) {
			dp[i] = arr[i];
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+arr[i]);
				}
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
