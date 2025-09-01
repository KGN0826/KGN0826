import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//n명 , 최대인원 K
		//남 - 1 여 - 0
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[6][2]; // 학년, 성별
		int count = 0;
		
		for(int i=0;i<n;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int man = Integer.parseInt(st2.nextToken());
			int grade = Integer.parseInt(st2.nextToken());
			
			if(man == 0) {// 여성
				arr[grade-1][man] += 1;
				if(arr[grade-1][man] > k) {
					arr[grade-1][man] = 1;
					count++;
				}
			}else {
				arr[grade-1][man] += 1;
				if(arr[grade-1][man] > k) {
					arr[grade-1][man] = 1;
					count++;
				}
			}
		}
		for(int i=0;i<6;i++) {
			for(int j=0;j<2;j++) {
				if(arr[i][j] != 0) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
