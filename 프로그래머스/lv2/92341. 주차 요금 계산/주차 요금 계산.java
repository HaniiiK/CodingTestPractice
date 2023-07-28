import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {        
        Map<String, Integer> car = new HashMap<>(); //차번호, 시간 저장
        Map<String, Boolean> isOut = new HashMap<>(); //차번호, 나갔는지 저장
        List<String> carNumber = new ArrayList<>(); //차번호만 저장

        int in=0; int out=0; int accum=0;
        for(int i=0; i<records.length; i++) {
            String[] carInfo = records[i].split(" ");
            
            if(carInfo[2].equals("IN")) {
                if(car.containsKey(carInfo[1])) { //이미 Map에 저장되어있는 차번호면
                    String[] inTime = carInfo[0].split(":");
                    in = Integer.parseInt(inTime[0])*60 + Integer.parseInt(inTime[1]);
                    accum = car.get(carInfo[1]);
                    car.replace(carInfo[1], in-accum); //새로 들어온 시간 - 누적 시간
                    isOut.replace(carInfo[1], false);
                }else { //처음 들어오는 차
                    carNumber.add(carInfo[1]);
                    String[] inTime = carInfo[0].split(":");
                    in = Integer.parseInt(inTime[0])*60 + Integer.parseInt(inTime[1]);
                    car.put(carInfo[1], in); //들어온 시간
                    isOut.put(carInfo[1], false);
                }
            }else if(carInfo[2].equals("OUT")) { //IN 없이 OUT만 있는 경우는 없다고 가정하고
                String[] outTime = carInfo[0].split(":");
                out = Integer.parseInt(outTime[0])*60 + Integer.parseInt(outTime[1]);
                in = car.get(carInfo[1]);
                car.replace(carInfo[1], out-in); //머물렀던 시간
                isOut.replace(carInfo[1], true);
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
//            System.out.println(sortCarNumber[i]+","+answer[i]);
        }
        
        return answer;
    }
}