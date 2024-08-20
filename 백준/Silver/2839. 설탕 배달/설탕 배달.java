import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N킬로그램 
		int cnt = 0;
		
		while(true) {
			if(N <=0) break; // N이 0보다 작아진다면 break
			
			if(N%5==0) {
				N-=5;
				cnt+=1;
			}
			else if(N%3==0) {
				N-=3;
				cnt+=1;
			}
			else if(N>=5) {
				N-=5;
				cnt+=1;
			}
			else {
				N-=3;
				cnt+=1;
			}
			
		}
		
		if(N==0) System.out.println(cnt);
		else System.out.println(-1);

	}

}