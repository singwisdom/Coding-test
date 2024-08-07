import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[12];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for (int i = 4; i < arr.length; i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(arr[num]);
		}

	}

}