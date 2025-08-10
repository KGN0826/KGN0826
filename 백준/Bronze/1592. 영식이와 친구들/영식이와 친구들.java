import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n= sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		int[] arr = new int[n];
		int count = 0;
		int position = 0;
		
		arr[0]++;
		
		while(arr[position] != m) {
			if(arr[position] %2 == 1) {
				arr[((position + l)%n)]++;
				position = (position+ l)%n;
				count++;
			} else {
				arr[(position+n-l)% n]++;
				position = (position+n-l)% n;
				count++;
			}
		}
		System.out.println(count);
	}
}
