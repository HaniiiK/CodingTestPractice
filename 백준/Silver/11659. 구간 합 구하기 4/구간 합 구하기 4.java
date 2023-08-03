import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] numbers = new int[N+1];
        int sum = 0;
        for(int i=1; i<N+1; i++) {
            numbers[i] = sc.nextInt();
            sum += numbers[i];
            numbers[i] = sum;
        }
        
        int[][] idxArr = new int[M][2];
        for(int i=0; i<M; i++) {
            idxArr[i][0] = sc.nextInt();
            idxArr[i][1] = sc.nextInt();
        }

        int[] answer = new int[M];
        for(int i=0; i<M; i++) {
            answer[i] = numbers[idxArr[i][1]] - numbers[idxArr[i][0]-1];
            System.out.println(answer[i]);
        }        
    }
}