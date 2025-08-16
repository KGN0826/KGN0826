import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		String text = br.readLine();
		char[] c = new char[text.length()];
		
		for(int i=0;i<text.length();i++) {
			c[i] = text.charAt(i);
		}
		
		int count = 0;
		for(int i=0;i<text.length();i++) {
			if(c[i] == 'c') {
				if(i<text.length()-1 && c[i+1] == '=' ||i<text.length()-1 && c[i+1] == '-') {
					count++;
					i++;
				}else {
					count++;
				}
			}else if(c[i] == 'd') {
				if(i<text.length()-2 && c[i+1] == 'z' && c[i+2] == '=') {
					count++;
					i += 2;
				}else if(i<text.length()-1 && c[i+1] == '-') {
					count++;
					i++;
				}else {
					count++;
				}
			}else if(i<text.length()-1 && c[i] == 'l' && c[i+1] == 'j') {
				count++;
				i++;
			}else if(i<text.length()-1 && c[i] == 'n' && c[i+1] == 'j') {
				count ++;
				i++;
			}else if(i<text.length()-1 && c[i] == 's' && c[i+1] == '=') {
				count++;
				i++;
			}else if(i<text.length()-1 && c[i] == 'z' && c[i+1] == '=') {
				count++;
				i++;
			}else {
				count++;
			}
		}
		System.out.println(count);
	}
}
