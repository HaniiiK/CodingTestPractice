import java.util.*;

class Solution {
    
    char[][] map;
    int sum;
        
    public int[] solution(String[] maps) {
            
        map = new char[maps.length+2][maps[0].length()+2];
        List<Integer> answerList = new ArrayList<>();
        
        //테두리 X로 두른 지도 만들기
        for(int i=0; i<map.length; i++) { 
            for(int j=0; j<map[0].length; j++) {
                if(i==0 || j==0 || i==map.length-1 || j==map[0].length-1) {
                    map[i][j] = 'X';
                }else {
                    map[i][j] = maps[i-1].charAt(j-1);
                }
            }
        }
        
        for(int i=1; i<map.length-1; i++) {
            for(int j=1; j<map[0].length-1; j++) {
                sum = 0;
                if(map[i][j]!='X') {
                    sum = dfs(map, i, j);
                    if(sum!=0) {
                        answerList.add(sum);
                    }
                }
            }
        }
        
        int[] answer;
        if(answerList.size()==0) {
            answer = new int[]{-1};
        }else {
            answer = new int[answerList.size()];
            for(int i=0; i<answerList.size(); i++) {
                answer[i] = answerList.get(i);
            }
            Arrays.sort(answer);
        }
        
        return answer;
    }
    
    public int dfs(char[][] map, int i, int j) {
        
        if(map[i][j]=='X') {
            return 0;
        }else {
            sum += map[i][j]-'0';
            map[i][j] = 'X';
        }
        
        dfs(map, i-1, j);
        dfs(map, i+1, j);
        dfs(map, i, j-1);
        dfs(map, i, j+1);
        
        return sum;
    }
}