import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 0; tc<10;tc++) {
			int t = Integer.parseInt(br.readLine());
			int count = 0;
			
			String find = br.readLine();
			String line = br.readLine();
			
			for(int i=0;i<line.length()-find.length()+1;i++) {
				boolean flag = true;
				for(int j=0;j<find.length();j++) {
					if(line.charAt(i+j) != find.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag == true) {
					count++;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#"+t+" "+count);
			System.out.println(sb);
		}
	}
}
