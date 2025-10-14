import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr, sel;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		sel = new int[M];
		
		for(int i=0;i<N;i++) {
			arr[i] = i+1;
		}
		
		comb(0,0);
		
		System.out.println(sb);
	}
	
	static void comb(int idx, int sidx) {
		if(sidx == M) {
			for(int i=0;i<M;i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=idx;i<N;i++) {
			sel[sidx] = arr[i];
			comb(i+1, sidx+1);
		}
	}
}
