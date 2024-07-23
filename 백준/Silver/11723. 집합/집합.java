import java.util.*;
import java.io.*;

public class Main {

	public static void add(int x) {
		set.add(x);
	}
	
	public static void remove(int x) {
		if(set.contains(x)) {
			set.remove(x);
		}
	}
	
	public static int check(int x) {
		if(set.contains(x)) {
			return 1;
		}
		else return 0;
	}
	
	public static void toggle(int x) {
		if(set.contains(x)) {
			set.remove(x);
		}
		else {
			set.add(x);
		}
	}
	
	public static void all() {
		set.clear();
		for(int i=1;i<=20;i++) {
			set.add(i);
		}
	}
	
	public static void empty() {
		set.clear();
	}
	
	static Set<Integer> set = new HashSet<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		int x = 0;
		
		for(int i=0;i<tc;i++){
			String[] buffer = br.readLine().split(" ");
			String word = buffer[0];
			if(buffer.length == 2) {
				x = Integer.parseInt(buffer[1]);
			}
				
			
			if(word.equals("add")) add(x);
			else if(word.equals("remove")) remove(x);
			else if(word.equals("check")) bw.write(check(x)+"\n");
			else if(word.equals("toggle")) toggle(x);
			else if(word.equals("all")) all();
			else if(word.equals("empty")) empty();
			
		}
		bw.flush();

	}

}
