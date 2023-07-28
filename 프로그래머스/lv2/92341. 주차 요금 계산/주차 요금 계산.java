import java.util.*;

class Solution {

    Map<String, Integer> car = new HashMap<>(); //차번호, 시간
    Map<String, Boolean> isOut = new HashMap<>(); //차번호, 나갔는지
    List<String> carNumber = new ArrayList<>(); //차번호
    
    public int[] solution(int[] fees, String[] records) {

        int in=0; int out=0; int accum=0;
        int time=0;
        for(int i=0; i<records.length; i++) {
            String[] carInfo = records[i].split(" ");
            String[] timeSeperate = carInfo[0].split(":");
            time = Integer.parseInt(timeSeperate[0])*60 + Integer.parseInt(timeSeperate[1]);
            
            if(carInfo[2].equals("IN")) {
                if(car.containsKey(carInfo[1])) { //들어왔던 적 있는 차
                    calcTime(carInfo[1], time, car.get(carInfo[1]), false);
                    // accum = car.get(carInfo[1]);
                    // car.replace(carInfo[1], time-accum); //새로 들어온 시간 - 누적 시간
                    // isOut.replace(carInfo[1], false);
                }else { //처음 들어오는 차
                    calcTime(carInfo[1], time, 0, false);
                    // carNumber.add(carInfo[1]);
                    // car.put(carInfo[1], time); //들어온 시간
                    // isOut.put(carInfo[1], false);
                }
            }else if(carInfo[2].equals("OUT")) {
                calcTime(carInfo[1], time, car.get(carInfo[1]), true);
                
                // in = car.get(carInfo[1]);
                // car.replace(carInfo[1], time-in); //머물렀던 시간
                // isOut.replace(carInfo[1], true);
            }
        }
        
        int[] answer = new int[car.size()];
        String[] sortCarNumber = carNumber.toArray(new String[carNumber.size()]); //차량 번호 정렬
        Arrays.sort(sortCarNumber);

        for(int i=0; i<carNumber.size(); i++) {
            if(!isOut.get(sortCarNumber[i])) { //OUT했는지 확인
                out = 23*60 + 59;
                in = car.get(sortCarNumber[i]);
                car.replace(sortCarNumber[i], out-in);
                isOut.replace(sortCarNumber[i], true);
            }
            
            answer[i] += fees[1]; //기본요금 더하기
            if(car.get(sortCarNumber[i]) > fees[0]) { //기본시간 초과하면 추가요금 더하기
                double t = Math.ceil((car.get(sortCarNumber[i])-fees[0])/(double)fees[2]);
                answer[i] += t * fees[3];
            }
        }
        return answer;
    }
    
    /*
    차번호, 현재 기록된 시간, 기록되어있던 시간, OUT인지 체크    
    */
    public void calcTime(String carNum, int presentTime, int pastTime, boolean outChk) {
        if(!carNumber.contains(carNum)) { //처음 들어오는 차
            carNumber.add(carNum);
            car.put(carNum, presentTime);
            isOut.put(carNum, outChk);
        }else {
            car.replace(carNum, presentTime-pastTime);
            isOut.replace(carNum, outChk);
        }
    }
    
}