import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int size = set.size();
        int numsSize = nums.length / 2;
        
        if(size < numsSize){
            answer = size;
        }
        return answer;
    }
}