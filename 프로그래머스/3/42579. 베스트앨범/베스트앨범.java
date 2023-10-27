import java.util.*;

class Solution {
    static class Element {
        int genreId;
        int idx;
        String genres;
        int times;
        public Element(int genreId, int idx, String genres, int times) {
            this.genreId = genreId;
            this.idx = idx;
            this.genres = genres;
            this.times = times;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        //1. 어떤 장르 수록할건지
        Map<String, Integer> map = new HashMap<>(); //name, sum
        for(int i=0; i<genres.length; i++) {
            if(map.containsKey(genres[i])) {
                int sum = map.get(genres[i]);
                map.replace(genres[i], sum+plays[i]);
            }else {
                map.put(genres[i], plays[i]);
            }
        }
        
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });        
        
        List<String> list = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : entryList) {
            list.add(entry.getKey());
        }
        
        //장르 개수만큼 pq 배열 생성해서 plays 넣어줌
        PriorityQueue<int[]>[] pq = new PriorityQueue[map.size()];
        for(int i=0; i<map.size(); i++) {
            pq[i] = new PriorityQueue<>(new Comparator<>(){
                @Override
                public int compare(int[] i1, int[] i2) {
                    return i2[0]-i1[0];
                }
            });
        }
        
        for(int i=0; i<genres.length; i++) {
            int idx = list.indexOf(genres[i]);
            pq[idx].offer(new int[]{plays[i], i});            
        }
        
        //장르 별로 두 개씩
        List<Integer> answerList = new ArrayList<>();
        int cnt = 0;
        
        for(int i=0; i<pq.length;) {
            answerList.add(pq[i].poll()[1]);
            cnt++;

            if(pq[i].isEmpty() || cnt==2) {
                i++;
                cnt = 0;
            }            
        }
//         while(true) {
            
//             if() {
//                 break;
//             }
//         }
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
              
        return answer;
    }
}