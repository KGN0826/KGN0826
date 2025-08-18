import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st2.nextToken());
		int y = Integer.parseInt(st2.nextToken());
		
		int t = Integer.parseInt(br.readLine());
		
		int xt = x+t;
		int yt = y+t;
		int resultX = 0;
		int resultY = 0;
		
		if(((int)xt/w)%2 ==0) {
			resultX = xt%w;
		}else {
			resultX = w-(xt%w);
		}
		if(((int)yt/h)%2 == 0) {
			resultY = yt%h;
		}else {
			resultY = h-(yt%h);
		}
		
		System.out.println(resultX+" "+resultY);
	}
}
