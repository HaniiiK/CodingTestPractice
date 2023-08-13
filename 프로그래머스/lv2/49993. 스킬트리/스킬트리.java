import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Queue<Character> queue = new LinkedList<>();
        boolean isPossible;
        for(int i=0; i<skill_trees.length; i++) {
            
            isPossible = true;
            queue.clear();
            for(int k=0; k<skill.length(); k++) {
                queue.add(skill.charAt(k));
            }
            
            for(int j=0; j<skill_trees[i].length(); j++) {
                if(!queue.isEmpty() && queue.contains(skill_trees[i].charAt(j))) {
                    if(skill_trees[i].charAt(j)==queue.peek()) {
                        queue.remove();
                    }else {
                        isPossible = false;
                        break;
                    }
                }
            }
            if(isPossible) {
                answer++;
            }
            
        }
        
        return answer;
    }
}