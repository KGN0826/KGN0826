import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int count = 1;
		int n = sc.nextInt();
		int a = 0;
		while(true) {
			if(n == 1) {
				a = 0;
				break;
			}
			if(n > count && n<= (6*a)+count) {
				break;
			}
			a++;
			count += (a-1)*6;
		}
		System.out.println(a+1);
	}
}
