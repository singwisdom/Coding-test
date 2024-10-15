import java.io.*;
import java.util.*;

public class Main {

	static char[][] map;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			String tmp = br.readLine();
			if(tmp.equals("end")) break;
			else {
				map = new char[3][3];
				int idx = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						map[i][j] = tmp.charAt(idx++);
					}
				}
				
				isvalid();

			}
			
		}
		bw.close();
	}
	
	private static boolean isvalid() throws IOException {
		
		/*
		 * 조건 1) 꽉 안 찬 경우 
		 * 		1-1) 빙고 && (X의 개수 - O의 개수 == 1) (X가 이긴경우)
		 * 		1-2) 빙고 && (X의 개수 == O의 개수) (O가 이긴 경우)
		 * 
		 * 조건 2) 꽉 찬 경우
		 *  	2-1) X빙고 && (X의 개수 - O의 개수 == 1)
		 *   	2-2) 아무의 빙고도 아님 && (X의 개수 - O의 개수 == 1)
		 * 
		 */
		
		int checkBlack = 0;
		int checkWhite = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(map[i][j] == 'X') {
					checkBlack++;
				} else if(map[i][j] == 'O') {
					checkWhite ++;
				}
			}
		}
		
		
		// 꽉 안 찬 경우
		if(!isFull()) {
			if(checkBlack - checkWhite == 1 && Bingo('X') && !Bingo('O')) {
				bw.write("valid\n");
				return true;
			}
			
			if(checkBlack == checkWhite && Bingo('O') && !Bingo('X')) {
				bw.write("valid\n");
				return true;
			}
			
		} // 꽉 찬경우
		else {
			if(Bingo('X') && !Bingo('O') && (checkBlack - checkWhite == 1)) {
				bw.write("valid\n");
				return true;
			}
			if(!Bingo('X') && !Bingo('O') && (checkBlack - checkWhite == 1)) {
				bw.write("valid\n");
				return true;
			}
		}
		
		bw.write("invalid\n");
		return false;

	}

	private static boolean Bingo(char str) {
		int cnt = 0;
		
		// 가로
		for (int i = 0; i < 3; i++) {
			cnt = 0;
			for (int j = 0; j < 3; j++) {
				if(map[i][j]  == str) cnt++;
			}
			if(cnt == 3) return true;
		}
		
		// 세로
		cnt = 0;
		for (int i = 0; i < 3; i++) {
			cnt = 0;
			for (int j = 0; j < 3; j++) {
				if(map[j][i]  == str) cnt++;
			}
			if(cnt == 3) return true;
		}
		
		// 왼쪽 대각선
		cnt = 0;
		for (int idx = 0; idx < 3; idx++) {
			if(map[idx][idx]  == str) cnt++;
		}
		if(cnt == 3) return true;
		
		// 오른쪽 대각선
		cnt = 0;
		for (int idx = 0; idx < 3; idx++) {
			if(map[idx][2-idx]  == str) cnt++;
		}
		if(cnt == 3) return true;
		
		
		return false;
	}

	private static boolean isFull() {
		int count = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(map[i][j] == '.') {
					count++;
				}
			}
		}
		
		if(count==0) return true;
		else return false;
		
	}

}