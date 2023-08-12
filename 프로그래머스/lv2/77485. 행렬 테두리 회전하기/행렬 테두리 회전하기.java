import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];
        int idx = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                board[i][j] = idx;
                idx++;
            }
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        int i, j;
        int pre, next; //pre: 지금 자리에 넣을 전 숫자, next: 다음 자리에 넣을 지금 숫자 저장
        int min;
        for(int k=0; k<queries.length; k++) {
            i = queries[k][0]-1;
            j = queries[k][1]-1;
            next = board[i][j];            
            min = board[i][j];
            
            while(true) {
                pre = next;
                if(i==queries[k][0]-1 && j<queries[k][3]-1) {
                    j++;
                }else if((i>=queries[k][0]-1 && i<queries[k][2]-1) && j==queries[k][3]-1) {
                    i++;
                }else if(i==queries[k][2]-1 && (j<=queries[k][3]-1 && j>queries[k][1]-1)) {
                    j--;
                }else if((i>queries[k][0]-1 && i<=queries[k][2]-1) && j==queries[k][1]-1) {
                    i--;
                }
                next = board[i][j];
                board[i][j] = pre;

                if(board[i][j]<min) {
                    min = board[i][j];
                }
                
                if(i==queries[k][0]-1 && j==queries[k][1]-1) {
                    break;
                }
            }
            answerList.add(min);
        }
        
        int[] answer = new int[answerList.size()];
        for(int k=0; k<answerList.size(); k++) {
            answer[k] = answerList.get(k);
        }
        return answer;
    }
}