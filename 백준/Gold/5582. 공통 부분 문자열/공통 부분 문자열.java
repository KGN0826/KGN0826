/*
 * 가장 긴 공통 부분 문자열 찾기
 * 문자열의 길이만큼 2차원 배열을 생성해서 같은 문자가 나올때마다
 * 이전에 나온 문자가 같은지 확인하고 1을 더한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//문자열 입력 받기
		String line1 = br.readLine();
		String line2 = br.readLine();
		
		int[][] dp = new int[line1.length()][line2.length()];
		
		int result = 0; // 가장 긴 문자열 길이 저장
		
		for(int i=0;i<line1.length();i++) {
			for(int j=0;j<line2.length();j++) {
				if(line1.charAt(i) == line2.charAt(j)) {
					if(i>=1 && j>=1) {
						dp[i][j] = dp[i-1][j-1]+1;
					}else {
						dp[i][j] = 1;
					}
				}
				result = Math.max(result, dp[i][j]);
			}
		}
		System.out.println(result);
	}
}
