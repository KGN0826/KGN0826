import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] dir = new int[6];
		int[] len = new int[6];
		int height = 0;
		int length = 0;
		int maxL=0;
		int maxH = 0;
		int subL = 0;
		int subH = 0;
		
		for(int i=0;i<6;i++) {
			dir[i] = sc.nextInt();
			len[i] = sc.nextInt();
		}
		
		for(int i=0;i<6;i++) {
			if(dir[i] == 1 || dir[i] == 2) {
				if(len[i]>= length) {
					maxL = i;
				}
				length = Math.max(length, len[i]);
			} else {
				if(len[i]>= height) {
					maxH = i;
				}
				height = Math.max(height, len[i]);
			}
		} // 가장 긴 길이의 i값과 그 값을 저장해놓음
		
		//가로 짧은 애들 중에서 양 옆에 세로 제일 짧은 애가 있는 걸 확인 or 반대
		for(int i=0;i<6;i++) {
			if( i != maxL && (dir[i] == 1 || dir[i] == 2)) {
				if(i == 0) {
					if(len[i+1] != height && len[5] != height) {
						subL = i;
					}
				}
				else if(i == 5) {
					if(len[0] != height && len[i-1] != height) {
						subL = i;
					}
				}else {
					if(len[i+1] != height && len[i-1] != height) {
						subL = i;
					}
				}
			}
			else if(i != maxH && (dir[i] == 3 || dir[i] == 4)) {
				if(i == 0) {
					if(len[i+1] != length && len[5] != length) {
						subH = i;
					}
				}
				else if(i == 5) {
					if(len[0] != length && len[i-1] != length) {
						subH = i;
					}
				}else {
					if(len[i+1] != length && len[i-1] != length) {
						subH = i;
					}
				}
			}
		}
		
		int mW = height * length;
		int sW = len[subL] * len[subH];
		
		int result = mW - sW;
		
		result *= n;
		System.out.println(result);
	}
}
