import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    int tc = Integer.parseInt(br.readLine());
	    
	    for(int i=1;i<=tc;i++) {
	        int n = Integer.parseInt(br.readLine());
	        int res = 0;
	        int tmp = 0; // 현재 속도를 저장하는 변수
	        
	        for(int j=0;j<n;j++) {
	            String[] cv = br.readLine().split(" ");
	            int command = Integer.parseInt(cv[0]);
	            int velocity = 0;
	            if(command !=0) {
	            	velocity = Integer.parseInt(cv[1]);
	            
	            }
	            
	            // 현재 속도를 유지할 경우, 그냥 속도만 더해줌
	            if(command == 0) {
	            	res += tmp;
	            }
	            
	            // 가속할경우, 현재속도+입력받은 가속도를 더해줌
	            else if(command == 1) {
	            	res += (tmp+velocity);
	            	tmp = tmp+velocity;
	            }
	            // 감속할경우
	            else if(command == 2) {
	            	if(tmp>velocity) { // 현재속도가 더 클 경우, 현재속도 - 가속도
	            		res += (tmp-velocity);
	            		tmp = tmp-velocity;
	            	}
	            	else {
	            		tmp = velocity = 0; // 감속도와 현재속도가 같거나 감속도가 더 클 경우, 이동속도는 0
	            	}
	            }
	            
	        }
	        bw.write("#"+i+" "+res+"\n");
	    }
	    bw.flush();
	    br.close();
	    bw.close();

	}

}