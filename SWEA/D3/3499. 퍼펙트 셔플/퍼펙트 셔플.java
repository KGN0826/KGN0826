import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(br.readLine());
			
			String[] s = br.readLine().trim().split(" ");
			List<String> p1 = new ArrayList<>();
			List<String> p2 = new ArrayList<>();
			
			if(s.length %2 == 0) {
				for(int i=0;i<s.length;i++) {
					if(i<s.length/2) {
						p1.add(s[i]);
					}else {
						p2.add(s[i]);
					}
				}
			}else {
				for(int i=0;i<s.length;i++) {
					if(i<s.length/2 +1) {
						p1.add(s[i]);
					}else {
						p2.add(s[i]);
					}
				}
			}
			System.out.print("#"+tc+" ");
			int a = 0;
			int b = 0;
			for(int i=0;i<s.length;i++) {
				if(i%2 ==0) {
					System.out.print(p1.get(a)+" ");
					a++;
				} else {
					System.out.print(p2.get(b)+" ");
					b++;
				}
			}
			System.out.println();
		}
	}
}
