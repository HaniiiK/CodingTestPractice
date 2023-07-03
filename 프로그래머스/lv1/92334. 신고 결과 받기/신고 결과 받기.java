import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        //중복 신고 제거
        Set<String> set = new HashSet<>();
        for(int i=0; i<report.length; i++) {
            set.add(report[i]);
        }
        
        //신고한 사람, 신고당한 사람
        String[][] reporters = new String[set.size()][2];
        int i=0;
        String s = "";
        Iterator iter = set.iterator();
        while(iter.hasNext()) {
            s = (String)iter.next();
            reporters[i] = s.split(" ");
            i++;
        }
        
        //신고 당한 사람들 횟수 저장
        Map<String, Integer> map = new HashMap<>();
        int num = 0;
        for(i=0; i<reporters.length; i++) {
            if(map.containsKey(reporters[i][1])) {
                num = map.get(reporters[i][1]);
                map.replace(reporters[i][1], ++num);
            }else {
                map.put(reporters[i][1], 1);
            }
        }
        
        //정지될 사람 list
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue()>=k) {
                list.add(entry.getKey());
            }
        }
        String[] arr = list.toArray(new String[list.size()]);

        for(i=0; i<reporters.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(reporters[i][1].equals(arr[j])) {
                    for(int l=0; l<id_list.length; l++) {
                        if(id_list[l].equals(reporters[i][0])) {
                            answer[l]++;
                            break;
                        }
                    }
                }
            }
            System.out.println();
        }
        
        return answer;
    }
}