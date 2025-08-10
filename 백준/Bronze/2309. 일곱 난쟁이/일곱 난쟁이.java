import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<9;i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		int num = 0;
		int num2 = 0;
		boolean flag = true;
		
		while (flag) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					if(i==j) {
						continue;
					}
					sum = 0;
					for(int z=0;z<9;z++) {
						sum += arr[z];
					}
					sum = sum - arr[i] - arr[j];
					if(sum == 100) {
						num = i;
						num2 = j;
						flag = false;
						break;
					}
				}
			}
		}
		
		for(int i=0;i<9;i++) {
			if( i != num && i !=num2) {
				list.add(arr[i]);
			}
		}
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
