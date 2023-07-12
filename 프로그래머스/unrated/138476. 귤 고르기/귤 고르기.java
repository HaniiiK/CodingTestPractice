import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int tmp = 0;
        for(int i=0; i<tangerine.length; i++) {
            if(map.containsKey(tangerine[i])) {
                tmp = map.get(tangerine[i]);
                map.replace(tangerine[i], ++tmp);
            }else {
                map.put(tangerine[i], 1);
            }
        }
        
        int[] arr = new int[map.size()];
        int i=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr[i] = entry.getValue();
            i++;
        }
        Arrays.sort(arr);
        
        int cnt = 0;
        for(i=arr.length-1; i>=0; i--) {
            if(cnt>=k) {
                break;
            }else {
                cnt+=arr[i];
            }
            answer++;
        }
        return answer;
    }
}