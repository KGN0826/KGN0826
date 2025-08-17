import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			int n = Integer.parseInt(br.readLine());
			int d = n%42;
			
			boolean flag = true;
			for(int j=0;j<list.size();j++) {
				if(list.get(j) == d) {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				list.add(d);
			}
		}
		System.out.println(list.size());
	}
}
