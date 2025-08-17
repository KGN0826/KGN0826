import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<t;tc++) {
			String s = br.readLine();
			char[] c = new char[s.length()];
			int sum = 0;
			
			int count = 1;
			for(int i=0;i<s.length();i++) {
				c[i] = s.charAt(i);
				if(c[i] == 'O') {
					sum += count++;
				}else {
					count = 1;
				}
			}
			System.out.println(sum);
		}
	}
}
