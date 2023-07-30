import java.util.*;

class Solution {

    int[][] chk = new int[11][11];
    int[] board = new int[2];
    Set<String> set = new HashSet<>();
    
    int answer = 0;

    public int solution(String dirs) {
        
        char c;
        for(int i=0; i<dirs.length(); i++) {
            c = dirs.charAt(i);
            
            switch(c) {
                case 'U':
                    if(board[1]<5) {
                        board[1]++;
                        check(board[0], board[1]-1);
                    }
                    break;
                case 'D':
                    if(board[1]>-5) {
                        board[1]--;
                        check(board[0], board[1]+1);
                    }
                    break;
                case 'R':
                    if(board[0]<5) {
                        board[0]++;
                        check(board[0]-1, board[1]);
                    }
                    break;
                case 'L':
                    if(board[0]>-5) {
                        board[0]--;
                        check(board[0]+1, board[1]);
                    }
                    break;
            }
//            System.out.println(board[0]+","+board[1]);
        }
        

        
        return answer;
    }
    
    public void check(int pastX, int pastY) {
        pastX += 5;
        pastY += 5;
        int x = board[0]+5;
        int y = board[1]+5;

        String s = pastX+""+pastY+""+x+""+y;
        if(!set.contains(s)) {
            answer++;
        }
        // if(chk[x][y]!=-1) {
        //     answer++;
        // }
        chk[x][y] = -1;
        set.add(s);
        set.add(x+""+y+""+pastX+""+pastY);
        
    }
    
    
}