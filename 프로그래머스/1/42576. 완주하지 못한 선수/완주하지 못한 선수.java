import java.util.*;

class Solution {
    
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> pMap = new HashMap<>();
        HashMap<String, Integer> cMap = new HashMap<>();
        String answer = "";
        
        for(int i=0; i<participant.length; i++){
            String name = participant[i];
            int cnt = pMap.getOrDefault(name, 0);
            if(cnt == 0){
                pMap.put(name, 1);
            } else {
                pMap.put(name, cnt+1);
            }
        }
        
        for(int i=0; i<completion.length; i++){
            String name = completion[i];
            int cnt = cMap.getOrDefault(name, 0);
            if(cnt == 0){
                cMap.put(name, 1);
            } else {
                cMap.put(name, cnt+1);
            }
        }
        
        // 답 구하기
        for(int i=0; i<participant.length; i++){
            String name = participant[i];
            int pCount = pMap.getOrDefault(name, 0);
            int cCount = cMap.getOrDefault(name, 0);
            
            if(pCount!= cCount){
                answer = name;
                break;
            }
        }
        
        return answer;
        
    }
}