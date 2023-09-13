import java.util.*;

class Solution {
    
    static String[] alphabets;
    static int cnt;
    static boolean isFound;
    
    public int solution(String word) {
        alphabets = new String[]{"A", "E", "I", "O", "U"};
        
        int answer = dfs(word, "", 0);
        
        return answer;
    }
    
    public static int dfs(String word, String nowWord, int length) {
        if(nowWord.equals(word)) {
            isFound = true;
            return cnt;
        }

        if(isFound) {
            return cnt;
        }

        cnt++;
        
        if(length==5) {
            return -1;
        }

        for(int i=0; i<5; i++) {
            dfs(word, nowWord + alphabets[i], length+1);
        }
        
        return cnt;
    }
}