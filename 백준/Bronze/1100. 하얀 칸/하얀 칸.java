import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] board = new String[8];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<8; i++) {
            board[i] = sc.next();
        }
        
        int answer = 0;
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if((i+j)%2==0 && board[i].charAt(j)=='F') {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}