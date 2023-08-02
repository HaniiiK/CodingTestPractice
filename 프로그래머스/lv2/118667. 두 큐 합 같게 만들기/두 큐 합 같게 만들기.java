import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int totalLength = queue1.length+queue2.length;
        int[] q1 = new int[totalLength*3];
        int[] q2 = new int[totalLength*3];

        int q1FirstIdx = 0, q2FirstIdx = 0;
        int q1LastIdx = queue1.length-1, q2LastIdx = queue2.length-1;
        
        long targetNum = 0;
        long sum1 = 0, sum2 = 0;
        for(int i=0; i<queue1.length; i++) {
            q1[i] = queue1[i];
            sum1 += queue1[i];
        }
        for(int i=0; i<queue2.length; i++) {
            q2[i] = queue2[i];
            sum2 += queue2[i];
        }
        targetNum = (sum1+sum2)/2;
        
        while(true) {
            if(answer>(totalLength)*2) {
                answer = -1;
                break;
            }
            if(q1LastIdx==q1.length || q2LastIdx==q2.length) {
                answer = -1;
                break;
            }
            if(sum1>targetNum) {
                q2LastIdx++;
                q2[q2LastIdx] = q1[q1FirstIdx];
                sum1 -= q1[q1FirstIdx];
                sum2 += q1[q1FirstIdx];
                q1FirstIdx++;
            }else if(sum1<targetNum) {
                q1LastIdx++;
                q1[q1LastIdx] = q2[q2FirstIdx];
                sum1 += q2[q2FirstIdx];
                sum2 -= q2[q2FirstIdx];
                q2FirstIdx++;
            }else if(sum1==targetNum) {
                break;
            }
            answer++;
            
            
        }
        
        return answer;
        
        
//         List<Long> list1 = new ArrayList<>();
//         List<Long> list2 = new ArrayList<>();
        
//         for(int i=0; i<queue1.length; i++) {
//             list1.add((long)queue1[i]);
//         }
//         for(int i=0; i<queue2.length; i++) {
//             list2.add((long)queue2[i]);
//         }
        
//         long sum1 = 0, sum2 = 0;
//         sum1 = getSum(list1);
//         sum2 = getSum(list2);
//         long targetNumber = (sum1+sum2)/2;
        
//         while(true) {
//             if(list1.isEmpty() || list2.isEmpty()) {
//                 answer = -1;
//                 break;
//             }
//             if(answer>(queue1.length+queue2.length)*2) {
//                 answer = -1;
//                 break;
//             }
    
//             if(sum1>targetNumber) {
//                 sum1 -= list1.get(0);
//                 list2.add(list1.remove(0));
//             }else if(sum1<targetNumber) {
//                 sum1 += list2.get(0);
//                 list1.add(list2.remove(0));
//             }else if(sum1==targetNumber) {
//                 break;
//             }
//             answer++;
//         }
        
//         return answer;
//     }
    
//     public long getSum(List list) {
//         long sum = 0;
//         int len = list.size();
//         for(int i=0; i<len; i++) {
//             sum += (long)list.get(i);
//         }
//         return sum;
    }
}