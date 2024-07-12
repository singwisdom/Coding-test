
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
		int[] arr = {2,3,5,7,11};
		
	
		for(int i=1;i<=tc;i++) {
			int num = sc.nextInt();
			int[] res = new int[5];
			
			while(true) {
				for(int j=0;j<5;j++) {
					if((num%arr[j]) == 0) {
						res[j] += 1;
						num /= arr[j];
					}
				}
				if(num==1) {
					break;
				}
			}
			System.out.print("#"+i);
			for(int j=0;j<5;j++) {
				System.out.print(" "+res[j]);
			}
			System.out.println();
		}
	}
}