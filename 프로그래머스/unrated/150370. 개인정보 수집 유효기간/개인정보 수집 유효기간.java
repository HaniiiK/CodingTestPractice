import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer_list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<terms.length; i++) {
            map.put(terms[i].charAt(0), Integer.parseInt(terms[i].substring(2)));
        }

        int today_year = Integer.parseInt(today.substring(0,4));
        int today_month = Integer.parseInt(today.substring(5,7));
        int today_day = Integer.parseInt(today.substring(8,10));
        
        for(int i=0; i<privacies.length; i++) {
            int year = Integer.parseInt(privacies[i].substring(0,4));
            int month = Integer.parseInt(privacies[i].substring(5,7));
            int day = Integer.parseInt(privacies[i].substring(8,10));
            month = month+map.get(privacies[i].charAt(privacies[i].length()-1));
            while(month>12) {
                year += 1;
                month -= 12;
            }
            // if(month > 12) {
            //     year += 1;
            //     month -= 12;
            // }

            if(today_year<year) {
                continue;
            }else if(today_year>year) {
                answer_list.add(i+1);
                continue;
            }else {
                if(today_month<month) {
                    continue;
                }else if(today_month>month) {
                    answer_list.add(i+1);
                    continue;
                }else {
                    if(today_day<day) {
                        continue;
                    }else {
                        answer_list.add(i+1);
                    }
                }
            }
        }

        int[] answer = new int[answer_list.size()];
        for(int i=0; i<answer_list.size(); i++) {
            answer[i] = answer_list.get(i);
        }
        return answer;
    }
}