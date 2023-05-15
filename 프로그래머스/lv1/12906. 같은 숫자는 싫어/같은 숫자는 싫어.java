import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // int cnt=0;        
        // for(int i=0; i<arr.length; i++) {
        //     if(i!=arr.length-1 && arr[i]==arr[i+1]) {
        //         continue;
        //     } else {
        //         cnt++;
        //     }
        // }
        // int[] answer = new int[cnt];
        // cnt=0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(i!=arr.length-1 && arr[i]==arr[i+1]) {
                continue;
            } else {
                list.add(arr[i]);
                // answer[cnt] = arr[i];
                // cnt++;
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}