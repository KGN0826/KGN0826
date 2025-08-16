import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		int sum = 0;
		int result = 0;
		int result2 = 0;
		
		for(int i=0;i<10;i++) {
			int a = Integer.parseInt(br.readLine());
			sum += a;
			if(sum > 100) {
				result = sum;
				result2 = sum-a;
				break;
			}
			if(i==9 && sum <= 100) {
				result = sum;
			}
		}
		if(Math.abs(result-100) > Math.abs(result2-100)) {
			System.out.println(result2);
		}else if(Math.abs(result-100) < Math.abs(result2-100)) {
			System.out.println(result);
		}else {
			System.out.println(Math.max(result, result2));
		}
	}
}
