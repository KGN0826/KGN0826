import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int[] arr = new int[t];
		int count = 1;
		
		for(int i=0;i<t;i++) {
			arr[i] = sc.nextInt();
		} 
		
		int pCount = sc.nextInt();
		
		int[] pArr = new int[pCount];
		int[] nArr = new int[pCount];
		
		for(int i=0;i<pCount;i++) {
			pArr[i] = sc.nextInt();
			nArr[i] = sc.nextInt(); 
		}
		
		for(int i=0;i<pCount;i++) {
			if(pArr[i]==1) {
				int j=1;
				while(nArr[i]*j <= arr.length) {
					if(arr[(nArr[i]*j)-1] == 1) {
						arr[(nArr[i]*j)-1] = 0;
					} else {
						arr[(nArr[i]*j)-1] =1;
					}
					j++;
				}
			}else {
				if(arr[nArr[i]-1] ==1) {
					arr[nArr[i]-1] = 0;
				} else {
					arr[nArr[i]-1] =1;
				}
				int result = 0;
				int a=1;
				while(nArr[i]-a-1>=0&& nArr[i]+a-1<=arr.length-1&&arr[nArr[i]-a-1] == arr[nArr[i]+a-1]) {
					result++;
					a++;
				}
				for(int b=1;b<=result;b++) {
					if(arr[nArr[i]-b-1] == 1) {
						arr[nArr[i]-b-1] = 0;
						arr[nArr[i]+b-1] = 0;
					}else {
						arr[nArr[i]-b-1] = 1;
						arr[nArr[i]+b-1] = 1;
					}
				}
			}
		}
		for(int i=0;i<t;i++) {
			if(i==20*count) {
				System.out.println();
				count++;
			}
			System.out.print(arr[i]+" ");
		}
	}
}
