import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		String text = br.readLine();
		int N = text.length();
		
		int r = 0;
		int c = 0;
		
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<N/i+1;j++) {
				if(i*j == N) {
					if(i>j && j>r) {
						c = i;
						r = j;
					}else if(i<=j && i>r) {
						r = i;
						c = j;
					}
				}
			}
		}
		
		int a = 0;
		char[][] arr = new char[r][c];
		for(int i=0;i<c;i++) {
			for(int j=0;j<r;j++) {
				arr[j][i] = text.charAt(a);
				a++;
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(arr[i][j]);
			}
		}
	}
}
