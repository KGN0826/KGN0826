import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1;tc<=10;tc++) {
			int t = Integer.parseInt(br.readLine());
			
			Queue<Integer> q = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<8;i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			int m = 1;
			while(true) {
				int num = q.poll();
				num -= m;
				if (num < 0) {
					num = 0;
				}
				q.offer(num);
				m++;
				if(m == 6) {
					m =1;
				}
				if(num==0) {
					break;
				}
			}
			System.out.print("#"+tc+" ");
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}
	}
}