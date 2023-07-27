import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        for(int i=0; i<cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        
        if(cacheSize==0) {
            answer = cities.length * 5;
        }else {
            List<String> list = new ArrayList<>(); //캐시에 있는 도시들
            for(int i=0; i<cities.length; i++) {
                if(list.contains(cities[i])) { //이미 캐시에 있는 도시면
                    answer++;
                    for(int j=0; j<list.size(); j++) { //list의 몇 번째 인덱스에 있는지 찾아서
                        if(list.get(j).equals(cities[i])) {
                            list.remove(j);
                            list.add(cities[i]); //제거하고 제일 끝에 넣어주기
//                            System.out.println("제일앞!"+list.get(0));
                            break;
                        }
                    }
                }else {
                    if(list.size()<cacheSize) { //cacheSize만큼 캐시(list) 채워주기
                        answer += 5;
                        list.add(cities[i]);
                    }else { //캐시에 없으면 list 제일 앞에있는거 지우고 넣어주기
                        list.remove(0);
                        list.add(cities[i]);
                        answer+=5;
//                        System.out.println("이거야?");
                    }
                }
//                System.out.println(cities[i]+","+answer);
            }
        }
        
        return answer;
    }
}