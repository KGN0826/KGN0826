import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1;t<=tc;t++) {
			Stack<Integer> stack = new Stack<>();
			
			int count = sc.nextInt();
			
			for(int i=0;i<count;i++) {
				int n = sc.nextInt();
				if(n != 0) {
					stack.push(n);
				} else {
					stack.pop();
				}
			}
			int sum = 0;
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}
