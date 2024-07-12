
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
			int n = sc.nextInt(); // 배열의 크기
			int word = sc.nextInt(); // 찾아야 하는 단어의 길이
			int[][] arr = new int[n][n];
			int res=0;
			
			for(int j=0;j<n;j++) { // 배열에 입력받기
				for(int k=0;k<n;k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			int count = 0;
			
			for(int j=0;j<n;j++) { // 가로 배열 탐색
				count = 0;
				for(int k=0;k<n;k++) {
					if(arr[j][k] == 1) {
						count += 1;
					}
					if(arr[j][k]==0 || k==n-1) {
						if(count==word) {
							res+=1;
						}
						count = 0;
					}
					
				}
				
			}
			
			
			// 세로배열 탐색
			for(int j=0;j<n;j++) { 
				count = 0;
				for(int k=0;k<n;k++) {
					if(arr[k][j] == 1) {
						count += 1;
					}
					if(arr[k][j]==0 || k==n-1) {
						if(count==word) {
							res+=1;
						}
						count = 0;
					}
					
				}
				
			}
			
			System.out.println("#"+i+" "+res);
			
		}
	}
}