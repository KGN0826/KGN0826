import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int t=0;t<n;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int pn1 = Integer.parseInt(st.nextToken());
			int pn2 = Integer.parseInt(st2.nextToken());
			
			int[] arr = new int[pn1];
			int[] arr2 = new int[pn2];
			
			int count14 = 0;
			int count24 = 0;
			int count13 = 0;
			int count23 = 0;
			int count12 = 0;
			int count22 = 0;
			int count11 = 0;
			int count21 = 0;
			
			
			for(int i=0;i<pn1;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(arr[i] == 4) {
					count14++;
				}else if(arr[i] == 3) {
					count13++;
				}else if(arr[i] == 2) {
					count12++;
				}else if(arr[i] == 1) {
					count11++;
				}
			}
			for(int i=0;i<pn2;i++) {
				arr2[i] = Integer.parseInt(st2.nextToken());
				if(arr2[i] == 4) {
					count24++;
				}else if(arr2[i] == 3) {
					count23++;
				}else if(arr2[i] == 2) {
					count22++;
				}else if(arr2[i] == 1) {
					count21++;
				}
			}
			
			if(count14 > count24) {
				System.out.println("A");
			}else if(count14 < count24) {
				System.out.println("B");
			}else {
				if(count13 > count23) {
					System.out.println("A");
				}else if(count13 < count23) {
					System.out.println("B");
				}else {
					if(count12 > count22) {
						System.out.println("A");
					}else if(count12 < count22) {
						System.out.println("B");
					}else {
						if(count11 > count21) {
							System.out.println("A");
						}else if(count11 < count21) {
							System.out.println("B");
						}else {
							System.out.println("D");
						}
					}
				}
			}
		}
	}
}
