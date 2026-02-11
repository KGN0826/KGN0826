/*
 * n개의 정수로 이루어진 수열
 * 한 정수 or 두 정수를 제거 가능
 * 한 정수 -> 그 정수가 점수
 * 두 정수 -> 두 정수의 곱이 점수
 * 수열에 아무 수도 남지 않게 되었을 때 점수의 총 합
 * 만약 1이면 곱하는게 더 손해임
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int [n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		long result = 0; //int 값 벗어나니까 long으로
		
		Arrays.sort(arr);
		boolean[] visited = new boolean[n];
		
		//음수일때만 먼저 계산
		for(int i=0;i<arr.length;i++) {
			if(arr[i] < 0) {
				if(visited[i]) continue;
				
				//음수 2개일 때
				if(i+1 < n && arr[i+1] <= 0) {
					visited[i] = true;
					visited[i+1]= true;
					result += (long) arr[i]*arr[i+1];
				}
				//음수 하나에 다음꺼 양수면 음수 더해버리기
				else if(i+1 < n && arr[i+1] > 0){
					visited[i] = true;
					result += arr[i];
					break; //양수 나왔으니까 더 해볼 필요 X
				}
			}
			//양수 나왔으면 더 해볼 필요가 없다.
			else {
				break;
			}
		}
		
		//양수일때
		for(int i=n-1;i>=0;i--) {
			if(arr[i]>0) {
				if(visited[i]) continue;
				
				// 둘 다 양수이면서 1이 아닐때
				if(i > 0 && arr[i-1] > 1 && !visited[i-1]) {
					visited[i] = true;
					visited[i-1]= true;
					result += (long) arr[i]*arr[i-1];
				}
				//1이 포함될 때
				else if(i > 0 && arr[i-1] >= 0 && !visited[i-1]){
					visited[i] = true;
					visited[i-1] = true;
					result += arr[i] + arr[i-1];
				}
				// 다음 수가 음수일때
				else if(i > 0 && arr[i-1] < 0 && !visited[i-1]){
					visited[i] = true;
					result += arr[i];
				}
			}
		}
		
		//혹시 방문 안 한거는 다 더해주기
		for(int i=0;i<arr.length;i++) {
			if(visited[i] == false) {
				result += arr[i];
			}
		}
		
		System.out.println(result);
	}
}
