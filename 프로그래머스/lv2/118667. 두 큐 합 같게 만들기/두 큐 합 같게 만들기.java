import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        //원래 큐로 돌아오는 경우보다 큰 크기의 배열 생성
        int totalLength = queue1.length+queue2.length;
        int[] q1 = new int[totalLength*2];
        int[] q2 = new int[totalLength*2];

        //각 큐의 합계, targetNum 구하기
        long sum1 = 0, sum2 = 0;
        for(int i=0; i<queue1.length; i++) {
            q1[i] = queue1[i];
            sum1 += queue1[i];
        }
        for(int i=0; i<queue2.length; i++) {
            q2[i] = queue2[i];
            sum2 += queue2[i];
        }
        long targetNum = (sum1+sum2)/2;
        
        //큐마다 first, last Idx
        int q1FirstIdx = 0, q2FirstIdx = 0;
        int q1LastIdx = queue1.length-1, q2LastIdx = queue2.length-1;
        
        while(true) {
            if(answer>(totalLength)*2) { //원래 큐로 돌아오면
                answer = -1;
                break;
            }
            if(sum1>targetNum) {
                q2[++q2LastIdx] = q1[q1FirstIdx];
                sum1 -= q1[q1FirstIdx++];
            }else if(sum1<targetNum) {
                q1[++q1LastIdx] = q2[q2FirstIdx];
                sum1 += q2[q2FirstIdx++];
            }else if(sum1==targetNum) {
                break;
            }
            answer++;
        }
        return answer;
    }
}