import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // TC 개수
        
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine()); // N, 방향
            int N = Integer.parseInt(st.nextToken()); // 배열의 크기
            String command = st.nextToken(); // 명령어 
            int[][] map = new int[N][N]; // 배열
            
            for (int i = 0; i < N; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 배열 입력받기
            }
            
            // 로직 : 숫자 합치기 -> 이동하기 
            if(command.equals("right")) {
            	// 숫자 합치기
                for (int i = 0; i < N; i++) {
                    int j = N-1;
                    
                    while(j>0) {
                        if(map[i][j]!=0) { // 숫자합치기
                        	                      
                        	if(map[i][j-1]==0) { // 바로 다음 숫자가 0이면 0이 안나올때까지 찾기,,
                        		int tmp = j-1;
                        		for (int k = j-1; k>=0; k--) {
									if(map[i][k]!=0) { // 0이 아닌 숫자가 나오면
										tmp = k; // 해당 위치로 j값 업데이트
										break;
									}
								}
                        		if(map[i][j] == map[i][tmp]) { // 숫자 합쳐!
                        			map[i][j] = map[i][j] + map[i][tmp];
                        			map[i][tmp] = 0;
                        			j = tmp;
                        		}
                        	}
                        	
                        	 // 다음 숫자가 0이 아니고, 현재 숫자와 같다면 합치기
                        	else if(map[i][j-1]!=0 && (map[i][j]==map[i][j-1])) {
                        		map[i][j] = map[i][j] + map[i][j-1];
                        		map[i][j-1] =0;
                        		j = j-1;
                        	}
                        	
                        }
                        j-=1;
                    }
                }
                
                // 숫자 이동하기 ~
                for (int i = 0; i < N; i++) {
					int j = N-1;
					while(j>0) {
						if(map[i][j]==0) {
							int tmp = j-1;
                    		for (int k = j-1; k>=0; k--) {
								if(map[i][k]!=0) { // 0이 아닌 숫자가 나오면
									tmp = k; // 해당 위치로 j값 업데이트
									break;
								}
							}
                    		if(map[i][tmp]!=0) { // 0과 해당 숫자를 바꿔주기
                    			map[i][j] = map[i][tmp];
                    			map[i][tmp] = 0;
                    		}
						}
						j-=1;
					}
				}
            }else if(command.equals("left")) {
            	
            	// 숫자 합치기
                for (int i = 0; i < N; i++) {
                    int j = 0;
                    
                    while(j<N-1) {
                        if(map[i][j]!=0) { // 숫자합치기
                        	                      
                        	if(map[i][j+1]==0) { // 바로 다음 숫자가 0이면 0이 안나올때까지 찾기,,
                        		int tmp = j+1;
                        		for (int k = j+1; k<N; k++) {
									if(map[i][k]!=0) { // 0이 아닌 숫자가 나오면
										tmp = k; // 해당 위치로 j값 업데이트
										break;
									}
								}
                        		if(map[i][j] == map[i][tmp]) { // 숫자 합쳐!
                        			map[i][j] = map[i][j] + map[i][tmp];
                        			map[i][tmp] = 0;
                        			j = tmp;
                        		}
                        	}
                        	
                        	 // 다음 숫자가 0이 아니고, 현재 숫자와 같다면 합치기
                        	else if(map[i][j+1]!=0 && (map[i][j]==map[i][j+1])) {
                        		map[i][j] = map[i][j] + map[i][j+1];
                        		map[i][j+1] =0;
                        		j = j+1;
                        	}
                        	
                        }
                        j+=1;
                    }
                }
                
                // 숫자 이동하기 ~
                for (int i = 0; i < N; i++) {
					int j = 0;
					while(j<N-1) {
						if(map[i][j]==0) {
							int tmp = j+1;
                    		for (int k = j+1; k<N; k++) {
								if(map[i][k]!=0) { // 0이 아닌 숫자가 나오면
									tmp = k; // 해당 위치로 j값 업데이트
									break;
								}
							}
                    		if(map[i][tmp]!=0) { // 0과 해당 숫자를 바꿔주기
                    			map[i][j] = map[i][tmp];
                    			map[i][tmp] = 0;
                    		}
						}
						j+=1;
					}
				}
                
            }else if(command.equals("down")) {
            	
            	// 숫자 합치기
                for (int j = 0; j < N; j++) {
                    int i = N-1;
                    
                    while(i>0) {
                        if(map[i][j]!=0) { // 숫자합치기
                        	                      
                        	if(map[i-1][j]==0) { // 바로 다음 숫자가 0이면 0이 안나올때까지 찾기,,
                        		int tmp = i-1;
                        		for (int k = i-1; k>=0; k--) {
									if(map[k][j]!=0) { // 0이 아닌 숫자가 나오면
										tmp = k; // 해당 위치로 j값 업데이트
										break;
									}
								}
                        		if(map[i][j] == map[tmp][j]) { // 숫자 합쳐!
                        			map[i][j] = map[i][j] + map[tmp][j];
                        			map[tmp][j] = 0;
                        			i = tmp;
                        		}
                        	}
                        	
                        	 // 다음 숫자가 0이 아니고, 현재 숫자와 같다면 합치기
                        	else if(map[i-1][j]!=0 && (map[i][j]==map[i-1][j])) {
                        		map[i][j] = map[i][j] + map[i-1][j];
                        		map[i-1][j] =0;
                        		i = i-1;
                        	}
                        	
                        }
                        i-=1;
                    }
                }
                
                // 숫자 이동하기 ~
                for (int j = 0; j < N; j++) {
					int i = N-1;
					while(i>0) {
						if(map[i][j]==0) {
							int tmp = i-1;
                    		for (int k = i-1; k>=0; k--) {
								if(map[k][j]!=0) { // 0이 아닌 숫자가 나오면
									tmp = k; // 해당 위치로 j값 업데이트
									break;
								}
							}
                    		if(map[tmp][j]!=0) { // 0과 해당 숫자를 바꿔주기
                    			map[i][j] = map[tmp][j];
                    			map[tmp][j] = 0;
                    		}
						}
						i-=1;
					}
				}
                
            }else if(command.equals("up")) {
            	
            	// 숫자 합치기
                for (int j = 0; j < N; j++) {
                    int i = 0;
                    
                    while(i<N-1) { 
                        if(map[i][j]!=0) { // 숫자합치기
                        	     
                        	if(map[i+1][j]==0) { // 바로 다음 숫자가 0이면 0이 안나올때까지 찾기,,
                        		int tmp = i+1;
                        	
                        		for (int k = i+1; k<N; k++) {
									if(map[k][j]!=0) { // 0이 아닌 숫자가 나오면
										tmp = k; // 해당 위치로 j값 업데이트
										break;
									}
								
								}
                        		if(map[i][j] == map[tmp][j]) { // 숫자 합쳐!
                        			map[i][j] = map[i][j] + map[tmp][j];
                        			map[tmp][j] = 0;
                        			i = tmp;
                  
                        		}
                        	}
                        	
                        	 // 다음 숫자가 0이 아니고, 현재 숫자와 같다면 합치기
                        	else if(map[i+1][j]!=0 && (map[i][j]==map[i+1][j])) {
                        		map[i][j] = map[i][j] + map[i+1][j];
                        		map[i+1][j] =0;
                        		i = i+1;

                        	}
                        	
                        }
                        i+=1;
                    }
                }
                
                // 숫자 이동하기 ~
                for (int j = 0; j < N; j++) {
					int i = 0;
					while(i<N-1) {
						if(map[i][j]==0) {
							int tmp = i+1;
                    		for (int k = i+1; k<N; k++) {
								if(map[k][j]!=0) { // 0이 아닌 숫자가 나오면
									tmp = k; // 해당 위치로 j값 업데이트
									break;
								}
							}
                    		if(map[tmp][j]!=0) { // 0과 해당 숫자를 바꿔주기
                    			map[i][j] = map[tmp][j];
                    			map[tmp][j] = 0;
                    		}
						}
						i+=1;
					}
				}
                
            }
            
            // 결과 출력
            bw.write("#"+t+"\n");
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
            		bw.write(map[i][j]+" ");
				}
            	bw.write("\n");
                
            }
        }
        // for문 End
        bw.flush();
        bw.close();

    }

}