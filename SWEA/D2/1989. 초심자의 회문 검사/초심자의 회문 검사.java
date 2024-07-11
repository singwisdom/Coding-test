
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
			
			String buffer = sc.next();
			int res = 1;
			
			for(int j=0;j<buffer.length();j++) {
				if(buffer.charAt(j) != buffer.charAt(buffer.length()-j-1)) {
					res = 0;
					break;
				}
			}
			
			System.out.println("#"+i+" "+res);
		}
	}
}