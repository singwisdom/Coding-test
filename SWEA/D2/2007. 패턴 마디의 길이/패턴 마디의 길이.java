
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
			char[] arr = new char[30];
			String tmp = "";
			boolean is_same = true;
			
			// 배열 입력받기
			for(int j=0;j<30;j++) { arr[j] = buffer.charAt(j);}
			tmp += arr[0];
			
			for(int j=1;j<30;j++) { 
				is_same = true;
				if(arr[0] == buffer.charAt(j)) // 첫글자와 같은 문자열이면 같은지 확인
				{
					for(int k=0;k<tmp.length();k++) {
						if(tmp.charAt(k)!=arr[j+k]) { // 처음부터 문자를 비교한 후, 다른지 확인
							tmp += arr[j];
							is_same = false;
							break;
						}
					}
					
					if(is_same) {break;} // 문자열이 모두 같다면 정답 출력
				}
				else {
					tmp += arr[j];
				}
			}
			System.out.println("#"+i+" "+tmp.length()); // 정답 출력
		}

	}
}