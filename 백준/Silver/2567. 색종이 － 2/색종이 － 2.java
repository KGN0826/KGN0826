import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int[][] arr = new int [100][100];
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<n;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int n1 = Integer.parseInt(st.nextToken());
    		int n2 = Integer.parseInt(st.nextToken());
    		
    		for(int a=0;a<10;a++) {
    			for(int b=0;b<10;b++) {
    				arr[n1+a][n2+b] += 1;
    			}
    		}
    	}
    	
    	int result = 0;
    	
    	for(int a=0;a<100;a++) {
    		for(int b=0;b<100;b++) {
    			if(b<99 && arr[a][b] == 0 && arr[a][b+1] != 0) {
    				result ++;
    			}else if(b<99 && arr[a][b] != 0 && arr[a][b+1] == 0) {
    				result++;
    			}
    			if(b == 99 && arr[a][b] != 0) {
    				result++;
    			}
    		}
    	}
    	for(int a=0;a<100;a++) {
    		for(int b=0;b<100;b++) {
    			if(b<99 && arr[b][a] == 0 && arr[b+1][a] != 0) {
    				result ++;
    			}else if(b<99 && arr[b][a] != 0 && arr[b+1][a] == 0) {
    				result++;
    			}
    			if(b == 99 && arr[b][a] != 0) {
    				result++;
    			}
    		}
    	}
    	System.out.println(result);
	}
}
