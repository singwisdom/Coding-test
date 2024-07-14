
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
		sc.nextLine();
		for(int i=1;i<=tc;i++) {
			int n = sc.nextInt();
			sc.nextLine();
			String[] arr = new String[n];
			int[] num = new int[n];
			StringBuilder tmp = new StringBuilder();
			
			for(int j=0;j<n;j++) {
				String input = sc.nextLine();
		        String[] buffer = input.split(" ");
				arr[j] = buffer[0];
				num[j] = Integer.parseInt(buffer[1]);
				
				for (int k = 0; k < num[j]; k++) {
	                 tmp.append(buffer[0]);
	             }
			}

			System.out.println("#"+i);
			for(int j=0;j<tmp.length();j++) {
				System.out.print(tmp.charAt(j));
				if((j+1)%10==0) {System.out.println();}
			}
			System.out.println();
			
		}
	}
}