import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1]; // 입력값 저장 배열
		int[] result = new int[n+1]; // 최대 합 저장 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}//입력 받기
		
		int r_result = Integer.MIN_VALUE; //결과값
		
		for(int i=1;i<=n;i++) {
			result[i] = Math.max(arr[i], arr[i]+result[i-1]);
			r_result = Math.max(r_result, result[i]);
		}
		System.out.println(r_result);
	}
}
