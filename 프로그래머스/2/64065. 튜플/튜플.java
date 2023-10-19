import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length()-1);
        String[] strs = s.split("[{}]");
        Arrays.sort(strs, (String s1, String s2) -> s1.length() - s2.length());

        List<Integer>[] list = new ArrayList[strs.length/2];
        for(int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }

        int idx = 0;
        for(int i=0; i<strs.length; i++) {
            if(!strs[i].isEmpty() && strs[i].charAt(0)>='0' && strs[i].charAt(0)<='9') {
                String[] ele = strs[i].split(",");
                for(int j=0; j<ele.length; j++) {
                    list[idx].add(Integer.parseInt(ele[j]));
                }
                idx++;
            }
        }
        
        int[] answer = new int[list.length];
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<list.length; i++) {
            for(int j=0; j<list[i].size(); j++) {
                if(!ans.contains(list[i].get(j))) {
                    ans.add(list[i].get(j));
                }
            }
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}