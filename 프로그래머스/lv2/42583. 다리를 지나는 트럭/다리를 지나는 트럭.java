import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int[] passedTime = new int[truck_weights.length]; //해당 트럭 인덱스에 다리 위에서 경과된 시간 저장
        Queue<Integer> waitingTrucks = new LinkedList<>(); //기다리는 트럭들
        for(int i=0; i<truck_weights.length; i++) {
            waitingTrucks.add(truck_weights[i]);
        }

        int idx = 0;
        int bridgeWeight = 0;
        int firstIdx = 0, lastIdx = 0;
        int time;
        while(true) {

            if(idx==0) { //처음 시작
                firstIdx = idx;
                lastIdx = idx;
                passedTime[idx]++;
                bridgeWeight += truck_weights[idx];
                idx++;
            }else {
                //시간 경과 체크
                for(int j=firstIdx; j<=lastIdx; j++) {
                    passedTime[j]++;
                }

                if(passedTime[firstIdx] > bridge_length) { //제일 앞에 있는 트럭이 다리를 건넜으면
                    bridgeWeight -= truck_weights[firstIdx];                    
                    if(bridgeWeight==0) {
                        //다리 위에 아무도 없으면
                        firstIdx = idx;
                    }else {
                        //다리 위에 다른 애도 있었으면
                        firstIdx++;
                    }

                }
                if(idx<truck_weights.length && weight >= bridgeWeight+truck_weights[idx]) { //아직 견딜 수 있는 무게면 다리에 올라오기
                    lastIdx = idx; //제일 뒤에 있는 트럭
                    passedTime[idx]++;
                    bridgeWeight += truck_weights[idx];
                    idx++;
                }
            }

            answer++;
            if(bridgeWeight==0 && idx==truck_weights.length) {
                break;
            }
            // for(int k=0; k<truck_weights.length; k++) {
            //     System.out.println(k+", "+passedTime[k]);
            // }
            // System.out.println();
        }
        

        return answer;
    }
}