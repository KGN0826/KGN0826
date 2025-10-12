import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int max = 0;
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(i==0) {
				for(int j=1;j<=num;j++) {
					stack.push(j);
					sb.append("+").append("\n");
					max = num;
				}
				stack.pop();
				sb.append("-").append("\n");
			}else {
				if(max < num) {
					for(int j=max;j<num;j++) {
						stack.push(j+1);
						sb.append("+").append("\n");
					}
					max = num;
					stack.pop();
					sb.append("-").append("\n");
				}else if(!stack.isEmpty() && stack.peek() == num) {
					stack.pop();
					sb.append("-").append("\n");
				}else if(!stack.isEmpty() && stack.peek() > num) {
					boolean flag = false;
					while(!stack.isEmpty()) {
						int a = stack.pop();
						if(a == num) {
							flag = true;
							break;
						}
					}
					if(!flag) {
						sb = new StringBuilder();
						sb.append("NO");
						break;
					}
				}else {
					sb = new StringBuilder();
					sb.append("NO");
					break;
				}
				
			}
		}
		System.out.println(sb);
	}
}
