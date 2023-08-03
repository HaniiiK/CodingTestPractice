import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[N+1][N+1];
        int rowSum = 0;
        for(int i=1; i<=N; i++) {
        	rowSum = 0;
        	st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
            	board[i][j] = Integer.parseInt(st.nextToken());
            	rowSum += board[i][j];
                board[i][j] = rowSum + board[i-1][j];
            }
        }
        
        int[][] idxArr = new int[M][4];
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
            idxArr[i][0] = Integer.parseInt(st.nextToken()); //x1
            idxArr[i][1] = Integer.parseInt(st.nextToken()); //y1
            idxArr[i][2] = Integer.parseInt(st.nextToken()); //x2
            idxArr[i][3] = Integer.parseInt(st.nextToken()); //y2
        }

        int[] answer = new int[M];
        for(int i=0; i<M; i++) {
        	answer[i] = board[idxArr[i][2]][idxArr[i][3]]
        			  - board[idxArr[i][0]-1][idxArr[i][3]]
        			  - board[idxArr[i][2]][idxArr[i][1]-1]
        			  + board[idxArr[i][0]-1][idxArr[i][1]-1];
        	
            System.out.println(answer[i]);
        }
    }
}