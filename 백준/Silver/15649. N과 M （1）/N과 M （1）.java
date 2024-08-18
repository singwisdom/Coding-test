import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		v = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}
		
		// 순열 뽑기
		perm(0,new int[m]);

	}

	private static void perm(int idx, int sel[]) {
		
		// basis part
		if(idx==sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();		
			return;
			
		}
		
		// inductive part
		for (int i = 0; i < arr.length; i++) {
			if(v[i] == false) {
				v[i] = true;
				sel[idx] = arr[i];
				perm(idx+1, sel);
				v[i] = false;
			}
		}
		
	}

}
