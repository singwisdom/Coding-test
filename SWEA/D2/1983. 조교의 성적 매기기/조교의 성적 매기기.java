import java.util.Arrays;
import java.util.Comparator;
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
		String[] score = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
		int tc = sc.nextInt();
		for(int i=1;i<=tc;i++) {
			int n = sc.nextInt(); // 학생수
			int std_num = sc.nextInt(); // 알고싶은 학생의 등수
			double[][] arr = new double[n][2];
			
			for(int j=0;j<n;j++) {
				// 중간,기말,과제 순으로 입력
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				arr[j][0] =(double)j+1;
				arr[j][1] = a*0.35 + b*0.45 + c*0.2;
			}
			
			// 2차원 배열 정렬 (성적 기준으로 정렬)
			Arrays.sort(arr, new Comparator<double[]>() {
		        @Override
		        public int compare(double[] o1, double[] o2) {
		            return Double.compare(o2[1], o1[1]);
		        }
		    });
			
			for(int j=0;j<n;j++) {
				if(arr[j][0] == (double)std_num) {
					System.out.println("#"+i+" "+score[j/(n/10)]);
				}
			}
					
			
		}
	}
}